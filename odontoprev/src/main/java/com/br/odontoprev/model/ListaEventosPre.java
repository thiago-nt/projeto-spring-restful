
package com.br.odontoprev.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idEvento", "tipoEvento", "valor" })
public class ListaEventosPre {

	@JsonProperty("idEvento")
	private String idEvento;
	@JsonProperty("tipoEvento")
	private String tipoEvento;
	@JsonProperty("valor")
	private BigDecimal valor;

	@JsonProperty("idEvento")
	public String getIdEvento() {
		return idEvento;
	}

	@JsonProperty("idEvento")
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	@JsonProperty("tipoEvento")
	public String getTipoEvento() {
		return tipoEvento;
	}

	@JsonProperty("tipoEvento")
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@JsonProperty("valor")
	public BigDecimal getValor() {
		return valor;
	}

	@JsonProperty("valor")
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
