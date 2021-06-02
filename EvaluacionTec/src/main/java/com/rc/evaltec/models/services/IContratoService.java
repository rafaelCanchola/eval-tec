package com.rc.evaltec.models.services;

import java.util.List;

import com.rc.evaltec.models.entity.Contrato;


public interface IContratoService {

	public List<Contrato> findAll();
	
	public Contrato save(Contrato contrato);
	
	public void delete(Long id);
	
	public Contrato findById(Long id);
	
	public List<Contrato> findAllByUsuarioNombre(String nombre);
	
	public List<Contrato> findAllByNodoEntrega(String idNodo);

	public Contrato findByFolio(String folio);

	public List<Contrato> findAllOrEntrega();
	
	public List<Contrato> findContratoByNodos();
	
	public Contrato totalFacturarNEGFecha();
	
	public List<Contrato> contratoInfraEnero();
	
	public Float promedioEneroCFE();
	
	public List<Contrato> nominaCero();

	public List<Contrato> menorDosMil();
	
	public List<Contrato> diasMarzo();

	public List<Contrato> listaFebrero();
	
	public Float minimoVal();
	
	public Float maxnimoVal();
	
}
