package com.br.odontoprev.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.ListaEventosPos;
import com.br.odontoprev.model.Orcamentos;
import com.br.odontoprev.repository.OrcamentosBeneficiarioRepository;
import com.br.odontoprev.service.OrcamentosBeneficiarioService;

@Service
public class OrcamentosBeneficiarioServiceImpl implements OrcamentosBeneficiarioService {

	@Autowired
	OrcamentosBeneficiarioRepository orcamentosBeneficiarioRepository;  
	
	@Override
	public Eventos gerar(Orcamentos orcamentos) {
		Eventos eventos = orcamentosBeneficiarioRepository.gerarEventos(orcamentos);
		eventos.setValorTotalEventosPos(somaValoresEventosPos(eventos));
		return eventos;
	}

	@Override
	public Eventos buscar(String idAssociado) {
		Eventos eventos = orcamentosBeneficiarioRepository.buscarEventosPorAssociado(idAssociado);
		eventos.setValorTotalEventosPos(somaValoresEventosPos(eventos));
		return eventos;
	}
	
	public BigDecimal somaValoresEventosPos(Eventos eventos) {
		BigDecimal somaEventosPos = new BigDecimal("0");
		for (ListaEventosPos listaPos : eventos.getListaEventosPos()) {
			BigDecimal somaEventosTemp = new BigDecimal(listaPos.getValor().toString());
			somaEventosPos = somaEventosPos.add(somaEventosTemp);
		}
		return somaEventosPos;
	}
}
