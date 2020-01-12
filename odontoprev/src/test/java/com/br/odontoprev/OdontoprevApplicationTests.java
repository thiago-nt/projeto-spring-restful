package com.br.odontoprev;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.ListaEventosPre;
import com.br.odontoprev.service.OrcamentosBeneficiarioService;
import com.br.odontoprev.service.impl.OrcamentosBeneficiarioServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = { "test" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OdontoprevApplicationTests {

	@Autowired
	OrcamentosBeneficiarioService orcamentosBeneficiarioService;
	private Eventos eventos = new Eventos();
	private static final String ID_ASSOCIADO = "12";

	@Before
	public void initialize() {
		eventos = orcamentosBeneficiarioService.buscar(ID_ASSOCIADO);
	}

	@Test
	public void validarSomaDeValoresPosPagamento() {
		OrcamentosBeneficiarioServiceImpl beneficiarioServiceImpl = new OrcamentosBeneficiarioServiceImpl();
		if (eventos.getValorTotalEventosPos().equals(beneficiarioServiceImpl.somaValoresEventosPos(eventos))) {
			Assert.assertTrue(Boolean.TRUE);
		} else {
			Assert.assertTrue(Boolean.FALSE);
		}
	}

	@Test
	public void validarValoresPrePagamentoVazio() {
		for (ListaEventosPre listaPre : eventos.getListaEventosPre()) {
			if (!StringUtils.isEmpty(listaPre.getValor())) {
				Assert.assertTrue(Boolean.FALSE);
			}
		}
	}

	@Test
	public void validarListaEventosPosPagamentoNotNull() {
		Assert.assertNotNull(eventos.getListaEventosPos());
	}

	@Test
	public void validarListaEventosPrePagamentoNotNull() {
		Assert.assertNotNull(eventos.getListaEventosPre());
	}
}
