package com.rc.evaltec.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rc.evaltec.models.dao.IEmpresaDao;
import com.rc.evaltec.models.entity.Empresa;
import com.rc.evaltec.models.services.IEmpresaService;

@Service
public class IEmpresaServiceImpl implements IEmpresaService{

	@Autowired
	private IEmpresaDao empresaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return empresaDao.findAll();
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaDao.save(empresa);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empresaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Empresa findById(Long id) {
		// TODO Auto-generated method stub
		return empresaDao.findById(id).get();
	}

	@Override
	public Empresa findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return empresaDao.findByNombre(nombre);
	}

}
