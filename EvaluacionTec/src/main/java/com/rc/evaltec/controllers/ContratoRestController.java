package com.rc.evaltec.controllers;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/ejercicioUno")
	public ResponseEntity<List<Contrato>> ejercicioUno(@RequestParam String nombre, @RequestParam Integer ejercicio){
		switch(ejercicio) {
		case 1:
			List<Contrato> findUsuario = contratoService.findAllByUsuarioNombre(nombre);
			System.out.println(findUsuario.size());
			return ResponseEntity.ok(findUsuario);
		case 2:
			List<Contrato> findFolio = new ArrayList<Contrato>();
			findFolio.add(contratoService.findByFolio(nombre));
			return ResponseEntity.ok(findFolio);
		case 4:
			List<Contrato> findAll =contratoService.findAllOrEntrega();
			return ResponseEntity.ok(findAll);
		case 11:
			List<Contrato> findAllByNodos =contratoService.findContratoByNodos();
			return ResponseEntity.ok(findAllByNodos);
		case 12:
			List<Contrato> findContratoFecha = new ArrayList<Contrato>();
			findContratoFecha.add(contratoService.totalFacturarNEGFecha());
			return ResponseEntity.ok(findContratoFecha);
		case 13:
			List<Contrato> contratoInfraEne =contratoService.contratoInfraEnero();
			Float getTotal = (float) 0;
			Contrato totalF = new Contrato();
			for(Contrato ci : contratoInfraEne) {
				getTotal += ci.getTotal();
			}
			totalF.setTotal(getTotal);
			contratoInfraEne.add(totalF);
			return ResponseEntity.ok(contratoInfraEne);
		case 14:
			List<Contrato> promedio = new ArrayList<Contrato>();
			Contrato prom = new Contrato();
			prom.setC_nom_rec(contratoService.promedioEneroCFE());
			promedio.add(prom );
			return ResponseEntity.ok(promedio);
		case 15:
			List<Contrato> nominaCero = contratoService.nominaCero();
			return ResponseEntity.ok(nominaCero);
		case 16:
			List<Contrato> menorDosMil = contratoService.menorDosMil() ;
			return ResponseEntity.ok(menorDosMil);
		default:
			return null;
		}
		
	}
	
	@GetMapping("/ejercicioTres")
	public ResponseEntity<List<Empresa>> ejercicioTres(@RequestParam String nombre, @RequestParam Integer ejercicio){
		switch(ejercicio) {
		case 3:
			List<Empresa> findUsuarioByNodo = empresaService.findByNodoRecepcion(nombre);
			System.out.println(findUsuarioByNodo.size());
			return ResponseEntity.ok(findUsuarioByNodo);
		
		default:
			return null;
		}
		
	}
	
	@GetMapping("/ejercicioCinco")
	public ResponseEntity<List<NodoComercial>> ejercicioCinco(@RequestParam String nombre, @RequestParam Integer ejercicio){
		switch(ejercicio) {
		case 5:
			List<NodoComercial> findByNodo = nodoService.findByRecepcion();
			System.out.println(findByNodo.size());
			return ResponseEntity.ok(findByNodo);
		case 6:
			List<NodoComercial> findByNodoEnt = nodoService.findByEntrega();
			System.out.println(findByNodoEnt.size());
			return ResponseEntity.ok(findByNodoEnt);
		default:
			return null;
		}
		
	}
	
	@GetMapping("/ejercicioSiete")
	public ResponseEntity<List<Usuario>> ejercicioSiete(@RequestParam String nombre, @RequestParam Integer ejercicio){
		switch(ejercicio) {
		case 7:
			List<Usuario> findByNodo = usuarioService.findByZonaTarifa(nombre);
			System.out.println(findByNodo.size());
			return ResponseEntity.ok(findByNodo);
		case 8:
			List<Usuario> findBy3Nodo = usuarioService.findBy3ZonaTarifa();
			System.out.println(findBy3Nodo.size());
			return ResponseEntity.ok(findBy3Nodo);
		case 9:
			List<Usuario> findByContrato = usuarioService.findByContrato();
			System.out.println(findByContrato.size());
			return ResponseEntity.ok(findByContrato);
		case 10:
			List<Usuario> findByNombreNodos = usuarioService.findNodosByNombre(nombre);
			System.out.println(findByNombreNodos.size());
			return ResponseEntity.ok(findByNombreNodos);
		
		default:
			return null;
		}
		
	}
	
	@PostMapping("/cargar")
	public ResponseEntity<List<Contrato>>loadCSV(@RequestParam MultipartFile file){
		System.out.println("CARGAR");
		if(file.getOriginalFilename().isEmpty()) {
			return ResponseEntity.status(409).build();
		}
		if(!CsvUtils.isCSVFile(file)) {
			System.out.println("Not CSV");
			return ResponseEntity.status(409).build();
		}
		List<Contrato> listCon = new ArrayList<Contrato>();
		try {
			List<CsvContrato> csvCont = CsvUtils.parseCsvFile(file.getInputStream());
			System.out.println(csvCont.size());
			int iterator = 1;
			for(CsvContrato contrato: csvCont) {
				System.out.println(iterator++);
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
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
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
			}
			return ResponseEntity.ok(listCon);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(409).build();
		}
	}
	

}
