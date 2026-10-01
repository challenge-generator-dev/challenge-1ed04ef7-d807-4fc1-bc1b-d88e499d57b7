package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO para transferencia de datos de pedidos")
public class OrderDTO {

    @Schema(description = "Identificador único del pedido", example = "1")
    private Long id;

    @Schema(description = "Fecha del pedido", example = "2024-01-15T10:30:00")
    private LocalDateTime orderDate;

    @NotNull(message = "El monto total es obligatorio")
    @Positive(message = "El monto total debe ser mayor a cero")
    @Schema(description = "Monto total del pedido", example = "2599.98", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal totalAmount;

    @NotBlank(message = "El estado del pedido es obligatorio")
    @Schema(description = "Estado del pedido", example = "PENDING", requiredMode = Schema.RequiredMode.REQUIRED)
    private String status;

    @NotNull(message = "El cliente es obligatorio")
    @Schema(description = "ID del cliente que realizó el pedido", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long customerId;

    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    private String customerName;

    @Schema(description = "Email del cliente", example = "juan.perez@example.com")
    private String customerEmail;

    @Schema(description = "Lista de ítems del pedido")
    private List<OrderItemDTO> items;

    @Schema(description = "Lista de IDs de productos en el pedido")
    private List<Long> productIds;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "DTO para ítems individuales del pedido")
    public static class OrderItemDTO {

        @NotNull(message = "El producto es obligatorio")
        @Schema(description = "ID del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long productId;

        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser al menos 1")
        @Schema(description = "Cantidad del producto", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer quantity;

        @NotNull(message = "El precio unitario es obligatorio")
        @Positive(message = "El precio unitario debe ser mayor a cero")
        @Schema(description = "Precio unitario del producto", example = "1299.99", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal unitPrice;
    }
}