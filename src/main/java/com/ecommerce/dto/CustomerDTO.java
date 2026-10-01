package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para transferencia de datos de clientes")
public class CustomerDTO {

    @Schema(description = "Identificador único del cliente", example = "1")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String lastName;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido")
    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@ejemplo.com")
    private String email;

    @Size(min = 6, max = 20, message = "El teléfono debe tener entre 6 y 20 caracteres")
    @Schema(description = "Teléfono del cliente", example = "+1234567890")
    private String phone;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 255, message = "La dirección no puede exceder 255 caracteres")
    @Schema(description = "Dirección principal del cliente", example = "Calle Principal 123")
    private String addressLine1;

    @Size(max = 255, message = "La dirección adicional no puede exceder 255 caracteres")
    @Schema(description = "Dirección adicional del cliente", example = "Apartamento 4B")
    private String addressLine2;

    @NotBlank(message = "La ciudad es obligatoria")
    @Size(max = 100, message = "La ciudad no puede exceder 100 caracteres")
    @Schema(description = "Ciudad del cliente", example = "Madrid")
    private String city;

    @NotBlank(message = "El estado o provincia es obligatorio")
    @Size(max = 100, message = "El estado no puede exceder 100 caracteres")
    @Schema(description = "Estado o provincia del cliente", example = "Comunidad de Madrid")
    private String state;

    @NotBlank(message = "El código postal es obligatorio")
    @Size(min = 3, max = 20, message = "El código postal debe tener entre 3 y 20 caracteres")
    @Schema(description = "Código postal del cliente", example = "28001")
    private String postalCode;

    @NotBlank(message = "El país es obligatorio")
    @Size(max = 100, message = "El país no puede exceder 100 caracteres")
    @Schema(description = "País del cliente", example = "España")
    private String country;

    @Schema(description = "Conjunto de pedidos asociados al cliente")
    private Set<Long> orderIds;
}