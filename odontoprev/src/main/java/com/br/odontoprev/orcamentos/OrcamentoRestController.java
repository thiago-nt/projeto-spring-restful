package com.br.odontoprev.orcamentos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.Orcamentos;
import com.br.odontoprev.orcamentos.docs.OrcamentoApi;
import com.br.odontoprev.service.OrcamentosBeneficiarioService;

import io.swagger.annotations.Api;

@Api(value = "Serviços para registrar e consultar orçamento dos eventos")
@RequestMapping("orcamentos")
@RestController
public class OrcamentoRestController implements OrcamentoApi {

	@Autowired
	OrcamentosBeneficiarioService orcamentosBeneficiarioService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrcamentoRestController.class);

	@PostMapping(value = "/gerar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Eventos> gerar(@RequestBody Orcamentos orcamentos) {
		LOGGER.info("[LOG] - Iniciando solicitacao de orcamento");
		Eventos eventos = orcamentosBeneficiarioService.gerar(orcamentos);
		LOGGER.info("[LOG] - Execucao realizada");
		return ResponseEntity.ok(eventos);
	}

	@GetMapping(value = "/{idAssociado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Eventos> buscar(@PathVariable("idAssociado") final String idAssociado) {
		LOGGER.info("[LOG] - Iniciando solicitacao de orcamento por associado");
		Eventos eventos = orcamentosBeneficiarioService.buscar(idAssociado);
		LOGGER.info("[LOG] - Execucao realizada");
		return ResponseEntity.ok(eventos);
	}
}
