package br.com.vivo.webservice.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Heroi extends AnaliseHeroi implements Comparable<Heroi> {
	private Integer id;
	private String nome;
	private List<Corrida> listCorrida;
	
	
	public Heroi() {
		this.listCorrida = new ArrayList<Corrida>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		String[] nomeArray = nome.trim().split("–");
		this.nome = nomeArray[1];
	}	
	
	public Integer getId() {
		return id;
	}	
	public void setId(String id) {
		String[] idArray = id.trim().split("–");
		this.id = Integer.parseInt(idArray[0]);
	}
	
	// Lista Corrida
	
	public List<Corrida> getListCorrida() {
		return listCorrida;
	}

	public void setListCorrida(List<Corrida> listCorrida) {
		this.listCorrida = listCorrida;
	}
	
	public void addCorrida(Corrida corrida) {
		this.listCorrida.add(corrida);
		this.setMelhorVoltaHeroi(this.listCorrida);
		this.setVelocidadeMediaTotal(this.listCorrida);
    }
 
    public void removeCorrida(Corrida corrida) {
    	this.listCorrida.remove(corrida);
    }
       
    
    @Override
	public int compareTo(Heroi heroi) {		
		if(heroi.getId() != null) {
			return this.getId().compareTo(heroi.getId());
		} else return 0;
	}

	@Override
	public String toString() {
		return "SuperHerois [id=" + id + ", nome=" + nome + "]";
	}
		

}
