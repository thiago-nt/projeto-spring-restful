package com.br.odontoprev.enumeration;

public enum TipoEvento {
	PRE_PAGAMENTO("N"), POS_PAGAMENTO("S");

	private String value;

	TipoEvento(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
