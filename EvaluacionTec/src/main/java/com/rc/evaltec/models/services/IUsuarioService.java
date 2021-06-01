package com.rc.evaltec.models.services;

import java.util.List;

import com.rc.evaltec.models.entity.Usuario;


public interface IUsuarioService {

public List<Usuario> findAll();
	
	public Usuario save(Usuario user);
	
	public void delete(Long id);
	
	public Usuario findById(Long id);
	
	public Usuario findByNodoId(String nodo);
	
}
