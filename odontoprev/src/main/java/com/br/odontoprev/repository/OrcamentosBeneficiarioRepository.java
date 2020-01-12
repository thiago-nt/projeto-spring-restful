package com.br.odontoprev.repository;

import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.Orcamentos;

public interface OrcamentosBeneficiarioRepository {

	public Eventos buscarEventosPorAssociado(String idAssociado);
	
	public Eventos gerarEventos(Orcamentos orcamentos);
	
}
