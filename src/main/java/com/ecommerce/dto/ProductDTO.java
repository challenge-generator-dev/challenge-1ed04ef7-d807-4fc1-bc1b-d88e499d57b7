package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO para transferencia de datos de productos")
public class ProductDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;

    @NotNull(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Schema(description = "Nombre del producto", example = "Laptop Gaming Pro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    @Schema(description = "Descripción del producto", example = "Laptop de alta gama para gaming")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    @Schema(description = "Precio del producto", example = "1299.99", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal price;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Schema(description = "Cantidad en stock", example = "50")
    private Integer stock;

    @Pattern(regexp = "^https?://.*", message = "La URL de imagen debe ser una URL válida")
    @Schema(description = "URL de la imagen del producto", example = "https://example.com/image.jpg")
    private String imageUrl;

    @Schema(description = "Conjunto de pedidos que incluyen este producto")
    private Set<Long> orderIds;
}