package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para la respuesta de autenticación con el token JWT")
public class JwtResponse {

    @Schema(description = "Token JWT para autenticación", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    @Schema(description = "Tipo de token", example = "Bearer")
    private String type;

    @Schema(description = "Nombre de usuario", example = "usuario@ejemplo.com")
    private String username;

    @Schema(description = "Roles del usuario", example = "[ROLE_USER, ROLE_ADMIN]")
    private java.util.List<String> roles;
}