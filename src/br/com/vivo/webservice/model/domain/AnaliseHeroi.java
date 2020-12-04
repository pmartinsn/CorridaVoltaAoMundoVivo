package br.com.vivo.webservice.model.domain;

import java.time.LocalTime;
import java.util.List;

public class AnaliseHeroi {
	private String melhorVoltaHeroi;
	private Double velocidadeMediaTotal;
		
	public String getMelhorVoltaHeroi() {	
		return melhorVoltaHeroi = melhorVoltaHeroi==null?new String():melhorVoltaHeroi;
	}
	protected void setMelhorVoltaHeroi(List<Corrida> listCorrida) {		
		for(Corrida tempoVolta:listCorrida) {
			if(this.melhorVoltaHeroi != null) {
				String[] tvS = tempoVolta.getTempoVolta().split("[:.]");
				LocalTime tvTime = LocalTime.of(0,Integer.parseInt(tvS[0]),Integer.parseInt(tvS[1]),Integer.parseInt(tvS[2]));				
				
				String[] mvhS = this.melhorVoltaHeroi.split("[:.]");
				LocalTime mvhTime = LocalTime.of(0,Integer.parseInt(mvhS[0]),Integer.parseInt(mvhS[1]),Integer.parseInt(mvhS[2]));
				
				if(tvTime.compareTo(mvhTime) < 0) 
					this.melhorVoltaHeroi = tempoVolta.getTempoVolta();
			}else {
				this.melhorVoltaHeroi = tempoVolta.getTempoVolta();
			}
		}
	}
	
	public Double getVelocidadeMediaTotal() {
		return velocidadeMediaTotal;
	}
	protected void setVelocidadeMediaTotal(List<Corrida> listCorrida) {
		for(Corrida velocidadeMedia:listCorrida) {
			if(this.velocidadeMediaTotal != null) {
				if(velocidadeMedia.getVelMediaVolta() < this.velocidadeMediaTotal.doubleValue()) {
					this.velocidadeMediaTotal = velocidadeMedia.getVelMediaVolta();
				}
			}
		}
	}	
	
	
}
