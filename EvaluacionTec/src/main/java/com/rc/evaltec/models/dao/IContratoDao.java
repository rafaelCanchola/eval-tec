package com.rc.evaltec.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.Contrato;

public interface IContratoDao extends JpaRepository<Contrato,Long>{
	
	@Query(value="SELECT * FROM ugtp_tbl_contratos WHERE ugtp_tbl_usuarios.id = ugtp_tbl_contratos.usuario_id AND ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = ?1",nativeQuery=true)
	List<Contrato> findAllByUsuarioNombre(String nombre);
	
	@Query(value="SELECT * FROM ugtp_tbl_contratos WHERE ugtp_tbl_contratos.usuario_id = ugtp_tbl_usuarios.id AND ugtp_tbl_usuarios.entrega_id = ?1",nativeQuery=true)
	List<Contrato> findAllByNodoEntrega(String idNodo);
	
	@Query(value="SELECT * FROM ugtp_tbl_contratos WHERE folio = ?1",nativeQuery = true)
	Contrato findByFolio(String folio);
}
