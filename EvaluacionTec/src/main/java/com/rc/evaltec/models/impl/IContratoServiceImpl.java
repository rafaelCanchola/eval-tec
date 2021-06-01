package com.rc.evaltec.models.impl;

import java.text.SimpleDateFormat;
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
		// TODO Auto-generated method stub
		return contratoDao.findAll();
	}

	@Override
	public Contrato save(Contrato contrato) {
		// TODO Auto-generated method stub
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		return contratoDao.save(contrato);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		contratoDao.deleteById(id);
		
	}

	@Override
	public Contrato findById(Long id) {
		// TODO Auto-generated method stub
		return contratoDao.findById(id).get();
	}

}
