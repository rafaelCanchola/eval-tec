package com.rc.evaltec.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	
	@Query(value= "SELECT * FROM ugtp_tbl_usuarios WHERE entrega = ?1", nativeQuery = true)
	Usuario findByNodoId(String nodo); 

}
