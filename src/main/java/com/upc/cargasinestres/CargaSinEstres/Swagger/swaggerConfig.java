package com.upc.cargasinestres.CargaSinEstres.Swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {
    @Bean
    public OpenAPI openApiConfig(){
        return new OpenAPI()
                .info(new Info()
                    .title("Carga Sin Estres")
                    .description("Documentación del backend de Carga Sin Estres")
                    .version("1.0.0")
                );
    }
}
