package com.rc.evaltec.models.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.evaltec.models.dao.IContratoDao;
import com.rc.evaltec.models.entity.Contrato;
import com.rc.evaltec.models.services.IContratoService;

@Service
public class IContratoServiceImpl implements IContratoService{

	@Autowired
	private IContratoDao contratoDao;
	@Override
	public List<Contrato> findAll() {
		return contratoDao.findAll();
	}

	@Override
	public Contrato save(Contrato contrato) {
		return contratoDao.save(contrato);
	}

	@Override
	public void delete(Long id) {
		contratoDao.deleteById(id);
		
	}

	@Override
	public Contrato findById(Long id) {
		return contratoDao.findById(id).get();
	}

	//Punto 1
	@Override
	public List<Contrato> findAllByUsuarioNombre(String nombre) {
		// TODO Auto-generated method stub
		return contratoDao.findAllByUsuarioNombre(nombre);
	}

	//Punto 4
	@Override
	public List<Contrato> findAllByNodoEntrega(String idNodo) {
		// TODO Auto-generated method stub
		return contratoDao.findAllByNodoEntrega(idNodo);
	}

	//Punto 2
	@Override
	public Contrato findByFolio(String folio) {
		// TODO Auto-generated method stub
		return contratoDao.findByFolio(folio);
	}

	@Override
	public List<Contrato> findAllOrEntrega() {
		// TODO Auto-generated method stub
		return contratoDao.findAllOrEntrega();
	}

	@Override
	public List<Contrato> findContratoByNodos() {
		// TODO Auto-generated method stub
		return contratoDao.findContratoByNodos();
	}

	@Override
	public Contrato totalFacturarNEGFecha() {
		// TODO Auto-generated method stub
		return contratoDao.totalFacturarNEGFecha();
	}

	@Override
	public List<Contrato> contratoInfraEnero() {
		// TODO Auto-generated method stub
		return contratoDao.contratoInfraEnero();
	}

	@Override
	public Float promedioEneroCFE() {
		// TODO Auto-generated method stub
		return contratoDao.promedioEneroCFE();
	}

	@Override
	public List<Contrato> nominaCero() {
		// TODO Auto-generated method stub
		return contratoDao.nominaCero();
	}

	@Override
	public List<Contrato> menorDosMil() {
		// TODO Auto-generated method stub
		return contratoDao.menorDosMil();
	}

	@Override
	public List<Contrato> diasMarzo() {
		// TODO Auto-generated method stub
		return contratoDao.diasMarzo();
	}

	@Override
	public List<Contrato> listaFebrero() {
		// TODO Auto-generated method stub
		return contratoDao.listaFebrero();
	}

	@Override
	public Float minimoVal() {
		// TODO Auto-generated method stub
		return contratoDao.minimoVal();
	}

	@Override
	public Float maxnimoVal() {
		// TODO Auto-generated method stub
		return contratoDao.maximoVal();
	}


}
