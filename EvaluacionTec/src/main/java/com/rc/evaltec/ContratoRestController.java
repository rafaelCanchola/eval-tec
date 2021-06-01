package com.rc.evaltec;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rc.evaltec.models.dto.CsvContrato;
import com.rc.evaltec.models.entity.Contrato;
import com.rc.evaltec.models.entity.Empresa;
import com.rc.evaltec.models.entity.NodoComercial;
import com.rc.evaltec.models.entity.Usuario;
import com.rc.evaltec.models.services.IContratoService;
import com.rc.evaltec.models.services.IEmpresaService;
import com.rc.evaltec.models.services.INodoComercialService;
import com.rc.evaltec.models.services.IUsuarioService;
import com.rc.evaltec.utils.CsvUtils;

@RestController
@RequestMapping("/api")
public class ContratoRestController {
	
	@Autowired
	private IContratoService contratoService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private INodoComercialService nodoService;

	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/cargar")
	public ResponseEntity<List<Contrato>>loadCSV(@RequestParam MultipartFile file){
		
		if(file.getOriginalFilename().isEmpty()) {
			return ResponseEntity.status(409).build();
		}
		if(!CsvUtils.isCSVFile(file)) {
			return ResponseEntity.status(409).build();
		}
		List<Contrato> listCon = new ArrayList<Contrato>();
		try {
			List<CsvContrato> csvCont = CsvUtils.parseCsvFile(file.getInputStream());
			for(CsvContrato contrato: csvCont) {
				Contrato ct = new Contrato();
				
				Usuario us = usuarioService.findByNodoId(contrato.getIdNodoEntrega());
				if(us == null) {
					Empresa em = empresaService.findByNombre(contrato.getUsuario());
					if(em == null) {
						Empresa emSer = new Empresa();
						emSer.setNombre(contrato.getUsuario());
						em = empresaService.save(emSer);
					}
					NodoComercial ncr = nodoService.findById(contrato.getIdNodoRecepcion());
					if(ncr == null) {
						NodoComercial nr = new NodoComercial();
						nr.setId(contrato.getIdNodoRecepcion());
						nr.setNombre(contrato.getNodoRecepcion());
						nr.setZonatarifa(contrato.getZonaInyeccion());
						ncr = nodoService.save(nr);
					}
					NodoComercial nr = new NodoComercial();
					nr.setId(contrato.getIdNodoEntrega());
					nr.setNombre(contrato.getNodoEntrega());
					nr.setZonatarifa(contrato.getZonaExtracción());
					nr = nodoService.save(nr);
					
					Usuario user = new Usuario();
					user.setUsuario(em);
					user.setEntrega(nr);
					user.setRecepcion(ncr);
					us = usuarioService.save(user);
					
				}
				ct.setUsuario(us);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				ct.setFecha(sdf.parse(contrato.getFecha()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				ct.setFolio(contrato.getContrato());
				ct.setC_nom_rec(contrato.getCantNomiRec());
				ct.setC_asi_rec(contrato.getCantAsigRec());
				ct.setC_nom_ent(contrato.getCantNomiEnt());
				ct.setC_asi_ent(contrato.getCantAsigEnt());
				ct.setExceso(contrato.getGasExceso());
				ct.setT_exceso(contrato.getTarifaExceso());
				ct.setT_uso(contrato.getTarifaUso());
				ct.setCargo_uso(contrato.getCargoUso());
				ct.setCargo_exceso(contrato.getCargoExceso());
				ct.setTotal(contrato.getTotal());
				listCon.add(contratoService.save(ct));
				//em.setNombre(contrato.getUsuario());
				return ResponseEntity.ok(listCon);	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(409).build();
		}
		return null;
	}
	

}
