package com.rc.evaltec.models.services;

import java.util.List;


import com.rc.evaltec.models.entity.NodoComercial;

public interface INodoComercialService {

	public List<NodoComercial> findAll();
	
	public NodoComercial save(NodoComercial nodo);
	
	public void delete(String id);
	
	public NodoComercial findById(String id);
	
	public List<NodoComercial> findByRecepcion();

	public List<NodoComercial> findByEntrega();
	
}
