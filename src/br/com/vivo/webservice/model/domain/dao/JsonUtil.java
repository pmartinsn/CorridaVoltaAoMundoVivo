package br.com.vivo.webservice.model.domain.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import br.com.vivo.webservice.model.domain.AnaliseCorrida;
import br.com.vivo.webservice.model.domain.Corrida;
import br.com.vivo.webservice.model.domain.Heroi;

public class JsonUtil {
	private static final String ARQUIVO = "C:\\Users\\pamela\\eclipse-workspaceJD\\webservice\\WebContent\\csv\\supers.csv";

	public List<Corrida> getCsvFileChegada() {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;
		List<Corrida> listChegada = new ArrayList<Corrida>();

		try {
			fileReader = new BufferedReader(new FileReader(ARQUIVO));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase(false).withTrim(true)
					.withDelimiter(';').withIgnoreEmptyLines(true).withNullString("")
			        .withIgnoreSurroundingSpaces(true));

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			
			for (CSVRecord csvRecord : csvRecords) {
				Corrida corrida = new Corrida();				
				corrida.setNumeroVolta(csvRecord.get("Nº Volta"));
				
				corrida.setId(csvRecord.get("Super-Heroi"));
				corrida.setNome(csvRecord.get("Super-Heroi"));
				corrida.setHora(csvRecord.get("Hora"));
				corrida.setTempoVolta(csvRecord.get("Tempo Volta"));
				corrida.setVelMediaVolta(csvRecord.get("Velocidade média da volta"));
				
				if(listChegada.isEmpty()) {
					if(corrida.getNumeroVolta()==4) {					
						listChegada.add(corrida);
					}
				}else {
					if(corrida.getNumeroVolta()>=3) {					
						listChegada.add(corrida);
					}
				}			
								
			}
			Collections.sort(listChegada);
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}
		return listChegada;
	}
	
	
	public AnaliseCorrida getCsvFile() {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;
		AnaliseCorrida analiseCorrida = new AnaliseCorrida();

		try {
			fileReader = new BufferedReader(new FileReader(ARQUIVO));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase(false).withTrim(true)
					.withDelimiter(';').withIgnoreEmptyLines(true).withNullString("")
			        .withIgnoreSurroundingSpaces(true));

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			
			for (CSVRecord csvRecord : csvRecords) {
				boolean ok = false;
				Heroi heroi = new Heroi();
				heroi.setId(csvRecord.get("Super-Heroi"));
				heroi.setNome(csvRecord.get("Super-Heroi"));				
				
				Corrida corrida = new Corrida();
				corrida.setHora(csvRecord.get("Hora"));
				corrida.setNumeroVolta(csvRecord.get("Nº Volta"));
				corrida.setTempoVolta(csvRecord.get("Tempo Volta"));
				corrida.setVelMediaVolta(csvRecord.get("Velocidade média da volta"));				
				
				for(Heroi superH:analiseCorrida.getListHeroi()) {
					if(superH.getId()==heroi.getId()) {
						superH.addCorrida(corrida);
						ok = true; break;
					}
				}
				
				if(!ok){
					heroi.addCorrida(corrida);
					analiseCorrida.addHeroi(heroi);
				}				
			}
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}
		return analiseCorrida;
	}	

}
