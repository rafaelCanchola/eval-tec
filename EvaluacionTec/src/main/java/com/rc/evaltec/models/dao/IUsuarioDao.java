package com.rc.evaltec.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	
	@Query(value= "SELECT * FROM ugtp_tbl_usuarios WHERE entrega_id = ?1", nativeQuery = true)
	Usuario findByNodoId(String nodo); 
	
	@Query(value= "SELECT ugtp_tbl_usuarios.* FROM ugtp_tbl_usuarios JOIN ugtp_tbl_nodos ON ugtp_tbl_usuarios.recepcion_id= ugtp_tbl_nodos.id AND ugtp_tbl_nodos.zonatarifa = ?1",nativeQuery=true)
	List<Usuario> findByZonaTarifa(String zona);
	
	@Query(value= "SELECT ugtp_tbl_usuarios.* FROM ugtp_tbl_usuarios JOIN ugtp_tbl_nodos ON ugtp_tbl_usuarios.entrega_id= ugtp_tbl_nodos.id AND (ugtp_tbl_nodos.zonatarifa = 'Zona 2' OR ugtp_tbl_nodos.zonatarifa = 'Zona 5' OR ugtp_tbl_nodos.zonatarifa = 'Zona 6')",nativeQuery=true)
	List<Usuario> findBy3ZonaTarifa();
	
	@Query(value="SELECT DISTINCT ugtp_tbl_usuarios.* FROM ugtp_tbl_usuarios JOIN ugtp_tbl_contrato ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id AND (ugtp_tbl_contrato.folio = 'CENAGAS/A/100/17' OR ugtp_tbl_contrato.folio = 'CENAGAS/A/500/17' OR ugtp_tbl_contrato.folio = 'CENAGAS/B/800/17' OR ugtp_tbl_contrato.folio ='CENAGAS/B/200/18')",nativeQuery=true)
	List<Usuario> findByContrato();
	
	@Query(value="SELECT ugtp_tbl_usuarios.* FROM ugtp_tbl_usuarios JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = ?1",nativeQuery=true)
	List<Usuario> findNodosByNombre(String nombre);
}
