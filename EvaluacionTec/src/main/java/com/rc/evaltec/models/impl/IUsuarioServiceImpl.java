package com.rc.evaltec.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.evaltec.models.dao.IUsuarioDao;
import com.rc.evaltec.models.entity.Usuario;
import com.rc.evaltec.models.services.IUsuarioService;

@Service
public class IUsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario save(Usuario user) {
		// TODO Auto-generated method stub
		return usuarioDao.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
		
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).get();
	}

	@Override
	public Usuario findByNodoId(String nodo) {
		// TODO Auto-generated method stub
		return usuarioDao.findByNodoId(nodo);
	}

	@Override
	public List<Usuario> findByZonaTarifa(String zona) {
		// TODO Auto-generated method stub
		return usuarioDao.findByZonaTarifa(zona);
	}

	@Override
	public List<Usuario> findBy3ZonaTarifa() {
		// TODO Auto-generated method stub
		return usuarioDao.findBy3ZonaTarifa();
	}

	@Override
	public List<Usuario> findByContrato() {
		// TODO Auto-generated method stub
		return usuarioDao.findByContrato();
	}

	@Override
	public List<Usuario> findNodosByNombre(String nombre) {
		// TODO Auto-generated method stub
		return usuarioDao.findNodosByNombre(nombre);
	}

	@Override
	public List<Usuario> cargoUso() {
		// TODO Auto-generated method stub
		return usuarioDao.cargoUso();
	}

	
}
