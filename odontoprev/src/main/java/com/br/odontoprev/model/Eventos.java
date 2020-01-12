
package com.br.odontoprev.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "listaEventosPre", "listaEventosPos", "valorTotalEventosPos" })
public class Eventos {

	@JsonProperty("listaEventosPre")
	private List<ListaEventosPre> listaEventosPre = null;
	@JsonProperty("listaEventosPos")
	private List<ListaEventosPos> listaEventosPos = null;
	@JsonProperty("valorTotalEventosPos")
	private BigDecimal valorTotalEventosPos;

	@JsonProperty("listaEventosPre")
	public List<ListaEventosPre> getListaEventosPre() {
		return listaEventosPre;
	}

	@JsonProperty("listaEventosPre")
	public void setListaEventosPre(List<ListaEventosPre> listaEventosPre) {
		this.listaEventosPre = listaEventosPre;
	}

	@JsonProperty("listaEventosPos")
	public List<ListaEventosPos> getListaEventosPos() {
		return listaEventosPos;
	}

	@JsonProperty("listaEventosPos")
	public void setListaEventosPos(List<ListaEventosPos> listaEventosPos) {
		this.listaEventosPos = listaEventosPos;
	}

	@JsonProperty("valorTotalEventosPos")
	public BigDecimal getValorTotalEventosPos() {
		return valorTotalEventosPos;
	}

	@JsonProperty("valorTotalEventosPos")
	public void setValorTotalEventosPos(BigDecimal valorTotalEventosPos) {
		this.valorTotalEventosPos = valorTotalEventosPos;
	}
}
