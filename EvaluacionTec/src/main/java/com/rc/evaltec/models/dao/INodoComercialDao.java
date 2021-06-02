package com.rc.evaltec.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.NodoComercial;

public interface INodoComercialDao extends JpaRepository<NodoComercial,String>{
	
	@Query(value= "SELECT DISTINCT ugtp_tbl_nodos.* FROM ugtp_tbl_nodos JOIN ugtp_tbl_usuarios ON ugtp_tbl_nodos.id = ugtp_tbl_usuarios.recepcion_id",nativeQuery=true)
	List<NodoComercial> findByRecepcion();
	
	@Query(value= "SELECT DISTINCT ugtp_tbl_nodos.* FROM ugtp_tbl_nodos JOIN ugtp_tbl_usuarios ON ugtp_tbl_nodos.id = ugtp_tbl_usuarios.entrega_id",nativeQuery=true)
	List<NodoComercial> findByEntrega();

}
