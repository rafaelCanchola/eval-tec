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
						record.get(csvParser.getHeaderNames().get(0)),record.get(csvParser.getHeaderNames().get(1)),record.get(csvParser.getHeaderNames().get(2)),record.get(csvParser.getHeaderNames().get(3)),record.get(csvParser.getHeaderNames().get(4)),record.get(csvParser.getHeaderNames().get(5)),record.get(csvParser.getHeaderNames().get(6)),record.get(csvParser.getHeaderNames().get(7)),record.get(csvParser.getHeaderNames().get(8)),
						Float.parseFloat(record.get(csvParser.getHeaderNames().get(9))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(10))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(11))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(12))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(13))),
						Float.parseFloat(record.get(csvParser.getHeaderNames().get(14))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(15))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(16))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(17))),Float.parseFloat(record.get(csvParser.getHeaderNames().get(18)))
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
