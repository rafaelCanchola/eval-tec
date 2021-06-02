package com.rc.evaltec.models.services;

import java.util.List;


import com.rc.evaltec.models.entity.Empresa;

public interface IEmpresaService {

public List<Empresa> findAll();
	
	public Empresa save(Empresa empresa);
	
	public void delete(Long id);
	
	public Empresa findById(Long id);
	
	public Empresa findByNombre(String nombre);
	
	public List<Empresa> findByNodoRecepcion(String nodo);

	
}
