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
	
}
