package br.com.vivo.webservice.service;

import java.util.List;

import br.com.vivo.webservice.model.domain.Corrida;
import br.com.vivo.webservice.model.domain.Heroi;
import br.com.vivo.webservice.model.domain.dao.JsonUtil;

public class HeroiService {
	
	private JsonUtil jsonUtil = new JsonUtil();
	
	public List<Heroi> getCsvFile(){
		return jsonUtil.getCsvFile().getListHeroi();
	}
	
	public Heroi getMelhorVoltaHeroi(){		
		return jsonUtil.getCsvFile().getMelhorVoltaCorrida();
	}	
	
	public List<Corrida> getChegada(){
		return jsonUtil.getCsvFileChegada();
	}

}
