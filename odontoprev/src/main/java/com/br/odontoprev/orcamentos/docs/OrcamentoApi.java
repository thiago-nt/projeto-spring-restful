package com.br.odontoprev.orcamentos.docs;

import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.odontoprev.model.Eventos;
import com.br.odontoprev.model.Orcamentos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Thiago.Tavares
 * @since 12-01-2020
 * Interface criada para especificar os métodos que a Api implementará.
 */
@Api(value = "orcamentos", tags = {"Orcamentos"})
public interface OrcamentoApi {

	@ApiOperation(
			value = "Responsavel em gerar um orcamento para o beneficiario", 
			nickname = "gerarOrcamentoParaBeneficiario",
			produces = MediaType.APPLICATION_JSON_VALUE,
			response = Eventos.class)
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<Eventos> gerar(@RequestBody Orcamentos orcamentos);

    @ApiOperation(
        value = "Responsavel em buscar orcamentos por associado",
        nickname = "buscarOrcamentoPorAssociado",
        produces = MediaType.APPLICATION_JSON_VALUE,
        response = Eventos.class
    )
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<Eventos> buscar(
    		@ApiParam(value = "Este parâmetro recebe o código do associado", example = "1")
            @NotNull
            @PathVariable("idAssociado") final String idAssociado
    );

}
