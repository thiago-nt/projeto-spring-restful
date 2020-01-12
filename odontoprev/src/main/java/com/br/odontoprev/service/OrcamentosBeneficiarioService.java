package com.br.odontoprev.service;

import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.Orcamentos;

public interface OrcamentosBeneficiarioService {

    Eventos gerar(Orcamentos orcamentos);
    
    Eventos buscar(String idAssociado);

}
