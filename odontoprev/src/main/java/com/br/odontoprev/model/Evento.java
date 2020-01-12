
package com.br.odontoprev.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idEvento" })
public class Evento {

	@JsonProperty("idEvento")
	private String idEvento;

	@JsonProperty("idEvento")
	public String getIdEvento() {
		return idEvento;
	}

	@JsonProperty("idEvento")
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

}
