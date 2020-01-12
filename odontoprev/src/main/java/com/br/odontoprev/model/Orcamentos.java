
package com.br.odontoprev.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "eventos", "idAssociado", "idDentista" })
public class Orcamentos {

	@JsonProperty("eventos")
	private List<Evento> eventos = null;
	@JsonProperty("idAssociado")
	private String idAssociado;
	@JsonProperty("idDentista")
	private String idDentista;

	@JsonProperty("eventos")
	public List<Evento> getEventos() {
		return eventos;
	}

	@JsonProperty("listaEventos")
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@JsonProperty("idAssociado")
	public String getIdAssociado() {
		return idAssociado;
	}

	@JsonProperty("idAssociado")
	public void setIdAssociado(String idAssociado) {
		this.idAssociado = idAssociado;
	}

	@JsonProperty("idDentista")
	public String getIdDentista() {
		return idDentista;
	}

	@JsonProperty("idDentista")
	public void setIdDentista(String idDentista) {
		this.idDentista = idDentista;
	}
}
