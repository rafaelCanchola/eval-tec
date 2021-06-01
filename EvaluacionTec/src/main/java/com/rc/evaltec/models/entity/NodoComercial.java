package com.rc.evaltec.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ugtp_tbl_nodos")
public class NodoComercial implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "id", unique= true, nullable = false, columnDefinition="text")
	@Setter @Getter
	private String id;
	
	@Column(columnDefinition="text")
	@Setter @Getter
	private String nombre;
	
	@Column(columnDefinition="text")
	@Setter @Getter
	private String zonatarifa;
}
