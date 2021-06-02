package com.rc.evaltec.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rc.evaltec.models.entity.Contrato;

public interface IContratoDao extends JpaRepository<Contrato,Long>{
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = ?1",nativeQuery=true)
	List<Contrato> findAllByUsuarioNombre(String nombre);
	
	@Query(value="SELECT * FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id AND ugtp_tbl_usuarios.entrega_id = ?1",nativeQuery=true)
	List<Contrato> findAllByNodoEntrega(String idNodo);
	
	@Query(value="SELECT * FROM ugtp_tbl_contrato RIGHT JOIN ugtp_tbl_usuarios ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id AND ugtp_tbl_usuarios.recepcion_id = ?1",nativeQuery=true)
	List<Contrato> findAllByNodoRecepcion(String idNodo);
	
	@Query(value="SELECT * FROM ugtp_tbl_contrato WHERE folio = ?1 LIMIT 1",nativeQuery = true)
	Contrato findByFolio(String folio);
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id AND (ugtp_tbl_usuarios.entrega_id = 'N103' OR ugtp_tbl_usuarios.entrega_id = 'N046' OR ugtp_tbl_usuarios.entrega_id = 'E168')",nativeQuery=true)
	List<Contrato> findAllOrEntrega();
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_usuarios.id = ugtp_tbl_contrato.usuario_id AND ugtp_tbl_usuarios.entrega_id = 'E076' AND ugtp_tbl_usuarios.recepcion_id = 'V033'",nativeQuery=true)
	List<Contrato> findContratoByNodos();
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_usuarios.id = ugtp_tbl_contrato.usuario_id JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = 'NEG Natural' AND ugtp_tbl_contrato.folio = 'CENAGAS/B/800/18' AND ugtp_tbl_contrato.fecha='2021-03-28'",nativeQuery=true)
	Contrato totalFacturarNEGFecha();
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_usuarios.id = ugtp_tbl_contrato.usuario_id JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = 'Energía Infra' AND '2021-01-01' <= ugtp_tbl_contrato.fecha AND ugtp_tbl_contrato.fecha < '2021-02-01' AND ugtp_tbl_contrato.total > 0",nativeQuery=true)
	List<Contrato> contratoInfraEnero();
	
	@Query(value="SELECT AVG(ugtp_tbl_contrato.c_nom_rec) FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_usuarios.id = ugtp_tbl_contrato.usuario_id JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = 'Comisión Federal de Electricidad' AND '2021-01-01' <= ugtp_tbl_contrato.fecha AND ugtp_tbl_contrato.fecha < '2021-02-01'",nativeQuery=true)
	Float promedioEneroCFE();
	
	@Query(value="SELECT * FROM ugtp_tbl_contrato WHERE ugtp_tbl_contrato.c_nom_rec = 0",nativeQuery=true)
	List<Contrato> nominaCero();
	
	@Query(value="SELECT * FROM ugtp_tbl_contrato WHERE ugtp_tbl_contrato.c_asi_ent < 2000;",nativeQuery=true)
	List<Contrato> menorDosMil();
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato WHERE '2021-03-29' <= ugtp_tbl_contrato.fecha AND ugtp_tbl_contrato.fecha < '2021-04-01'",nativeQuery=true)
	List<Contrato> diasMarzo();
	
	@Query(value="SELECT ugtp_tbl_contrato.* FROM ugtp_tbl_contrato WHERE ugtp_tbl_contrato.c_nom_ent < 1600 AND ugtp_tbl_contrato.fecha = '2021-02-14'",nativeQuery=true)
	List<Contrato> listaFebrero();
	
	@Query(value="SELECT Min(ugtp_tbl_contrato.total) as t_exceso FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = 'Enestas' AND ugtp_tbl_contrato.total > 0",nativeQuery=true)
	Float minimoVal();
	
	@Query(value="SELECT Max(ugtp_tbl_contrato.total) as t_uso FROM ugtp_tbl_contrato JOIN ugtp_tbl_usuarios ON ugtp_tbl_contrato.usuario_id = ugtp_tbl_usuarios.id JOIN ugtp_tbl_empresas ON ugtp_tbl_usuarios.empresa_id = ugtp_tbl_empresas.id AND ugtp_tbl_empresas.nombre = 'Enestas' AND ugtp_tbl_contrato.total > 0",nativeQuery=true)
	Float maximoVal();

}
