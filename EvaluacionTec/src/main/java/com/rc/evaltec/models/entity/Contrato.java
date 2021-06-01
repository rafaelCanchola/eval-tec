package com.rc.evaltec.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ugtp_tbl_contrato")
public class Contrato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter @Getter
	private Long id;
	
	@Column(columnDefinition="text")
	@Setter @Getter
	private String folio;
	
	@Setter @Getter
	private LocalDate fecha;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	@Setter @Getter
	private Usuario usuario;
	
	@Setter @Getter
	private Float c_nom_rec;
	
	@Setter @Getter
	private Float c_asi_rec;

	@Setter @Getter
	private Float c_nom_ent;
	
	@Setter @Getter
	private Float c_asi_ent;
	
	@Setter @Getter
	private Float exceso;
	
	@Setter @Getter
	private Float t_exceso;
	
	@Setter @Getter
	private Float t_uso;
	
	@Setter @Getter
	private Float cargo_uso;
	
	@Setter @Getter
	private Float cargo_exceso;
	
	@Setter @Getter
	private Float total;
	
	
	
	
	
	
	
	
	
}
