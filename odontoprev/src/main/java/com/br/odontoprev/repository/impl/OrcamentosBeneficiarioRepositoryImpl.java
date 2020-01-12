package com.br.odontoprev.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.br.odontoprev.config.Constantes;
import com.br.odontoprev.enumeration.TipoEvento;
import com.br.odontoprev.model.Evento;
import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.ListaEventosPos;
import com.br.odontoprev.model.ListaEventosPre;
import com.br.odontoprev.model.Orcamentos;
import com.br.odontoprev.repository.OrcamentosBeneficiarioRepository;

@Repository
public class OrcamentosBeneficiarioRepositoryImpl implements OrcamentosBeneficiarioRepository {

	@Override
	public Eventos buscarEventosPorAssociado(String idAssociado) {
		Orcamentos orcamentos = new Orcamentos();
		Eventos eventos = new Eventos();
		if (idAssociado.equals("12")) {
			List<Evento> eventosList = new ArrayList<>();
			Evento evento = new Evento();
			evento.setIdEvento(Constantes.NUMBER_200001);
			eventosList.add(evento);
			evento = new Evento();
			evento.setIdEvento(Constantes.NUMBER_200002);
			eventosList.add(evento);
			evento = new Evento();
			evento.setIdEvento(Constantes.NUMBER_200003);
			eventosList.add(evento);
			evento = new Evento();			
			evento.setIdEvento(Constantes.NUMBER_200004);
			eventosList.add(evento);
			orcamentos.setEventos(eventosList);
			eventos = gerarEventos(orcamentos);
		}
		return eventos;
	}

	@Override
	public Eventos gerarEventos(Orcamentos orcamentos) {
		List<ListaEventosPos> listaEventosPos = new ArrayList<>();
		List<ListaEventosPre> listaEventosPre = new ArrayList<>();
		ListaEventosPos eventosPos = new ListaEventosPos();
		ListaEventosPre eventosPre = new ListaEventosPre();
		Eventos eventos = new Eventos();

		for (Evento evento : orcamentos.getEventos()) {
			eventosPos = adicionarEventosPos(listaEventosPos, eventosPos, evento);
			eventosPre = adicionarEventosPre(listaEventosPre, eventosPre, evento);
		}
		eventos.setListaEventosPos(listaEventosPos);
		eventos.setListaEventosPre(listaEventosPre);
		return eventos;
	}

	private ListaEventosPre adicionarEventosPre(List<ListaEventosPre> listaEventosPre, ListaEventosPre eventosPre,
			Evento evento) {
		if (evento.getIdEvento().equals(Constantes.NUMBER_200001)) {
			eventosPre.setIdEvento(Constantes.NUMBER_200001);
			eventosPre.setTipoEvento(TipoEvento.PRE_PAGAMENTO.getValue());
			listaEventosPre.add(eventosPre);
		} else if (evento.getIdEvento().equals(Constantes.NUMBER_200002)) {
			eventosPre = new ListaEventosPre();
			eventosPre.setIdEvento(Constantes.NUMBER_200002);
			eventosPre.setTipoEvento(TipoEvento.PRE_PAGAMENTO.getValue());
			listaEventosPre.add(eventosPre);
		}
		return eventosPre;
	}

	private ListaEventosPos adicionarEventosPos(List<ListaEventosPos> listaEventosPos, ListaEventosPos eventosPos,
			Evento evento) {
		if (evento.getIdEvento().equals(Constantes.NUMBER_200003)) {
			eventosPos.setIdEvento(Constantes.NUMBER_200003);
			eventosPos.setTipoEvento(TipoEvento.POS_PAGAMENTO.getValue());
			eventosPos.setValor(new BigDecimal("40.00"));
			listaEventosPos.add(eventosPos);
		} else if (evento.getIdEvento().equals(Constantes.NUMBER_200004)) {
			eventosPos = new ListaEventosPos();
			eventosPos.setIdEvento(Constantes.NUMBER_200004);
			eventosPos.setTipoEvento(TipoEvento.POS_PAGAMENTO.getValue());
			eventosPos.setValor(new BigDecimal("51.00"));
			listaEventosPos.add(eventosPos);
		}
		return eventosPos;
	}
}
