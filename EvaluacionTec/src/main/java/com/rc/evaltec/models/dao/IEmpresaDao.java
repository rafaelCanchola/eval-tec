package com.rc.evaltec.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.Empresa;

public interface IEmpresaDao extends JpaRepository<Empresa,Long>{

	@Query(value="SELECT * FROM ugtp_tbl_empresas WHERE nombre = ?1", nativeQuery = true)
	Empresa findByNombre(String nombre);
	
	@Query(value="SELECT DISTINCT ugtp_tbl_empresas.* FROM ugtp_tbl_usuarios JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_usuarios.recepcion_id = ?1",nativeQuery=true)
	List<Empresa> findByNodoRecepcion(String nodo);

}
