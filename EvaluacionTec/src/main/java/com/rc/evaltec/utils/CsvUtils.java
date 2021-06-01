package com.rc.evaltec.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.rc.evaltec.models.dto.CsvContrato;

public class CsvUtils {
	
	private static String csvExtension = "csv";
	
	public static List<CsvContrato> parseCsvFile(InputStream is){
		BufferedReader fileReader = null;
		CSVParser csvParser = null;
		
		List<CsvContrato> contratos = new ArrayList<CsvContrato>();
		
		try {
			fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
	
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for(CSVRecord record:csvRecords) {
				CsvContrato contrato = new CsvContrato(
						record.get("Fecha"),record.get("Contrato"),record.get("Usuario"),record.get("Nodo Comercial Recepción"),record.get("Descripción Nodo Comercial Recepción "),record.get("Nodo Comercial Entrega"),record.get("Descripción Nodo Comercial Entrega"),record.get("Zona de Tarifa de Inyección"),record.get("Zona de Tarifa de Extracción"),
						Float.parseFloat(record.get("Cantidad Nominada Recepción (GJ/día)")),Float.parseFloat(record.get("Cantidad Asignada Recepción (GJ/día)")),Float.parseFloat(record.get("Cantidad Nominada Entrega (GJ/día)")),Float.parseFloat(record.get("Cantidad Asignada Entrega (GJ/día)")),Float.parseFloat(record.get(" Gas en Exceso (GJ/día)")),
						Float.parseFloat(record.get("Tarifa Exceso Firme (Pesos/GJ) ")),Float.parseFloat(record.get("Tarifa Uso Interrumpible (Pesos/GJ)")),Float.parseFloat(record.get("Cargo Uso (Pesos)")),Float.parseFloat(record.get("Cargo Gas en Exceso (Pesos)")),Float.parseFloat(record.get("Total a facturar (Pesos)"))
						);
				contratos.add(contrato);
			}
		}catch(Exception e) {
			System.out.println("Error al leer csv");
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
				csvParser.close();
			}catch(IOException e) {
				System.out.println("Error al cerrar el archivo");
				e.printStackTrace();
			}
		}
		return contratos;
	}
	
	public static boolean isCSVFile(MultipartFile file) {
		String extension = file.getOriginalFilename().split("\\.")[1];
		return extension.equals(csvExtension);
	}
}
