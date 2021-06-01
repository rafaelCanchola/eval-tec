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

}
