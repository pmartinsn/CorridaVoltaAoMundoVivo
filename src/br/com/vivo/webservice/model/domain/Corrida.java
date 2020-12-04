package br.com.vivo.webservice.model.domain;

public class Corrida implements Comparable<Corrida>{
	private Integer id;
	private String nome;
	private int posicao = 0;
	
	private String hora;
	private int numeroVolta;
	private String tempoVolta;
	private double velMediaVolta;
	
		
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
	public String getHora() {		
		return hora;
	}
	public void setHora(String hora) {		
		this.hora = hora;
	}
	
	public int getNumeroVolta() {
		return numeroVolta;
	}
	public void setNumeroVolta(String numeroVolta) {
		this.numeroVolta = Integer.parseInt(numeroVolta);
	}
	
	public String getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(String tempoVolta) {		
		this.tempoVolta = tempoVolta;
	}
	
	public double getVelMediaVolta() {
		return velMediaVolta;
	}
	public void setVelMediaVolta(String velMediaVolta) {
		String rpc = velMediaVolta.replace(",", ".");
		this.velMediaVolta = Double.parseDouble(rpc);
	}		
	
	@Override
	public String toString() {
		return "Corrida [ hora=" + hora + ", numeroVolta=" + numeroVolta + ", tempoVolta=" + tempoVolta
				+ ", velMediaVolta=" + velMediaVolta + "]";
	}
	
	@Override
	public int compareTo(Corrida corrida) {
		if(corrida.getHora() != null) {
			return this.hora.compareTo(corrida.getHora());
		} else return 0;
	}
	public int getPosicao() {
		return ++posicao;
	}
	
		
}
