package com.rc.evaltec.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CsvContrato{

	@Setter @Getter
	private String fecha;

	@Setter @Getter
	private String contrato;

	@Setter @Getter
	private String usuario;

	@Setter @Getter
	private String idNodoRecepcion;

	@Setter @Getter
	private String nodoRecepcion;

	@Setter @Getter
	private String idNodoEntrega;

	@Setter @Getter
	private String nodoEntrega;

	@Setter @Getter
	private String zonaInyeccion;

	@Setter @Getter
	private String zonaExtracción;

	@Setter @Getter
	private Float cantNomiRec;

	@Setter @Getter
	private Float cantAsigRec;

	@Setter @Getter
	private Float cantNomiEnt;

	@Setter @Getter
	private Float cantAsigEnt;

	@Setter @Getter
	private Float gasExceso;

	@Setter @Getter
	private Float tarifaExceso;
	
	@Setter @Getter
	private Float tarifaUso;
	
	@Setter @Getter
	private Float cargoUso;

	@Setter @Getter
	private Float cargoExceso;

	@Setter @Getter
	private Float total;
}
