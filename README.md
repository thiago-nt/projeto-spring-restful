## Sistema para gerar e consultar orçamento para beneficiário.

# Pré-requisitos
   IDE Eclipse ou InteliJ.
   Versão minima Java 8.
   Maven

# Tecnologia
SpringBoot com Maven 
Java 8

# Para inicializar o projeto e utilizar em modo desenvolvimento.
   mvn spring-boot:run
    
# Endpoints local com Swagger
 # http://localhost:8080/swagger-ui.html#/orcamento-rest-controller/gerarOrcamentoParaBeneficiario
 # http://localhost:8080/swagger-ui.html#/orcamento-rest-controller/buscarOrcamentoPorAssociado

# Exemplo de entrada em JSON para endpoint gerarOrcamentoParaBeneficiario
{
  "idAssociado": "12",
  "idDentista": "1",
  "eventos": [
    {
       "idEvento": "200001"
    },
    {
       "idEvento": "200002"
    },
    {
       "idEvento": "200003"
    },
    {
       "idEvento": "200004"
    }
  ]
}

# Exemplo de entrada em JSON para endpoint buscarOrcamentoPorAssociado
  Código idAssociado = 12

# Exemplo Retorno JSON para os endpoints buscarOrcamentoPorAssociado e gerarOrcamentoParaBeneficiario
{
  "listaEventosPre": [
    {
      "idEvento": "200001",
      "tipoEvento": "N"
    },
    {
      "idEvento": "200002",
      "tipoEvento": "N"
    }
  ],
  "listaEventosPos": [
    {
      "idEvento": "200003",
      "tipoEvento": "S",
      "valor": 40
    },
    {
      "idEvento": "200004",
      "tipoEvento": "S",
      "valor": 51
    }
  ],
  "valorTotalEventosPos": 91
}




