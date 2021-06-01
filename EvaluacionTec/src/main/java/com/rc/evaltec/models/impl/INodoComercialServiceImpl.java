package com.rc.evaltec.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rc.evaltec.models.dao.INodoComercialDao;
import com.rc.evaltec.models.entity.NodoComercial;
import com.rc.evaltec.models.services.INodoComercialService;

@Service
public class INodoComercialServiceImpl implements INodoComercialService{

	@Autowired
	private INodoComercialDao nodoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<NodoComercial> findAll() {
		// TODO Auto-generated method stub
		return nodoDao.findAll();
	}

	@Override
	@Transactional
	public NodoComercial save(NodoComercial nodo) {
		// TODO Auto-generated method stub
		return nodoDao.save(nodo);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		nodoDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public NodoComercial findById(String id) {
		// TODO Auto-generated method stub
		return nodoDao.findById(id).get();
	}

	
}
