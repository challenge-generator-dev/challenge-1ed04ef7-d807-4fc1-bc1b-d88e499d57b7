package com.ecommerce.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String BEARER_FORMAT = "JWT";
    private static final String SCHEME_NAME = "Bearer Authentication";
    private static final String SCHEME_DESCRIPTION = "JWT token-based authentication";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce API")
                        .version("1.0")
                        .description("REST API para gestión de productos y pedidos en e-commerce. " +
                                "Incluye autenticación JWT, documentación automática y manejo de errores centralizado.")
                        .contact(new Contact()
                                .name("E-Commerce Team")
                                .email("support@ecommerce.com")
                                .url("https://www.ecommerce.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat(BEARER_FORMAT)
                                .description(SCHEME_DESCRIPTION)));
    }
}