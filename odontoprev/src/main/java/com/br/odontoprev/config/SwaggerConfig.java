package com.br.odontoprev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.br.odontoprev.orcamentos"))
                .build()
                .groupName("Odontoprev APIs")
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .termsOfServiceUrl("Orçamentos de eventos")
                .title("API de Microserviço orçamentos de eventos")
                .description("API referente orçamentos de eventos")
                .version("v1")
                .build();
    }
}

