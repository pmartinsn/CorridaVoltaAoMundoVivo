package br.com.vivo.webservice.model.domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AnaliseCorrida {
	private List<Heroi> listHeroi;
	private Heroi melhorVoltaCorrida;
	
	//COSTRUTOR
	public AnaliseCorrida() {
		listHeroi = new ArrayList<Heroi>();
	}	
	
	
	// GET-SET
	public Heroi getMelhorVoltaCorrida() {
		return melhorVoltaCorrida;
	}
	public void setMelhorVoltaCorrida(List<Heroi> listHeroi) {
		for(Heroi heroi:listHeroi) {
			if(this.melhorVoltaCorrida != null) {
				String[] tvS = heroi.getMelhorVoltaHeroi().split("[:.]");
				LocalTime tvTime = LocalTime.of(0,Integer.parseInt(tvS[0]),Integer.parseInt(tvS[1]),Integer.parseInt(tvS[2]));				
				
				String[] mvhS = this.melhorVoltaCorrida.getMelhorVoltaHeroi().split("[:.]");
				LocalTime mvhTime = LocalTime.of(0,Integer.parseInt(mvhS[0]),Integer.parseInt(mvhS[1]),Integer.parseInt(mvhS[2]));
				
				if(tvTime.compareTo(mvhTime) <0) 
					this.melhorVoltaCorrida = heroi;
			}else {
				this.melhorVoltaCorrida = heroi;
			}
		}
	}
		
	
	//LISTA	
	public List<Heroi> getListHeroi() {
		this.setMelhorVoltaCorrida(this.listHeroi);
		return listHeroi;
	}

	public void setListHeroi(List<Heroi> listHeroi) {
		this.listHeroi = listHeroi;
	}

	public void addHeroi(Heroi heroi) {
		this.listHeroi.add(heroi);
    }
 
    public void removeHeroi(Heroi heroi) {
    	listHeroi.remove(heroi);
    }
	
//	@Override
//	public int compareTo(Heroi heroi) {
//		if(heroi.getId() != null) {
//			return ((Heroi) this.listHeroi).getId().compareTo(heroi.getId());
//		} else return 0;
//	}
	
}
