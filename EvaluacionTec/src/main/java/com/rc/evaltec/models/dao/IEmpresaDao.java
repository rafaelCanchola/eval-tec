package com.rc.evaltec.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.Empresa;

public interface IEmpresaDao extends JpaRepository<Empresa,Long>{

	@Query(value="SELECT * FROM ugtp_tbl_empresas WHERE nombre = ?1", nativeQuery = true)
	Empresa findByNombre(String nombre);
}
