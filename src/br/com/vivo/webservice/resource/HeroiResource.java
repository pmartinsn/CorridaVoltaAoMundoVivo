package br.com.vivo.webservice.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.vivo.webservice.model.domain.Corrida;
import br.com.vivo.webservice.model.domain.Heroi;
import br.com.vivo.webservice.service.HeroiService;

@Path("/supers")
public class HeroiResource {

	private HeroiService service = new HeroiService();

	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Heroi> getSupers() {
		return service.getCsvFile();
	}

	@GET
	@Path("/melhorvolta/heroi")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Heroi getMelhorVoltaHeroi() {
		return service.getMelhorVoltaHeroi();		
	}
	
	@GET
	@Path("/chegada")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Corrida> getChegada() {
		return service.getChegada();
	}

}
