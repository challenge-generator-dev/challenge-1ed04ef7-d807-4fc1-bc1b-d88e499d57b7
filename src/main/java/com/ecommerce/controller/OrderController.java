package com.ecommerce.controller;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Orders", description = "API para gestión de pedidos del e-commerce")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los pedidos", description = "Retorna una lista paginada de pedidos del sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de pedidos obtenida exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Page.class))),
        @ApiResponse(responseCode = "400", description = "Parámetros de paginación inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<Page<OrderDTO>> getAllOrders(
            @Parameter(description = "Parámetros de paginación y ordenamiento")
            @PageableDefault(size = 10, sort = "orderDate") Pageable pageable) {
        Page<OrderDTO> orders = orderService.findAll(pageable);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pedido por ID", description = "Retorna un pedido específico basado en su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido encontrado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = OrderDTO.class))),
        @ApiResponse(responseCode = "404", description = "Pedido no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<OrderDTO> getOrderById(
            @Parameter(description = "ID del pedido a buscar", example = "1")
            @PathVariable Long id) {
        OrderDTO order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo pedido", description = "Registra un nuevo pedido en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido creado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = OrderDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos del pedido inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<OrderDTO> createOrder(
            @Parameter(description = "Datos del pedido a crear")
            @Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.save(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pedido", description = "Actualiza los datos de un pedido existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = OrderDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos del pedido inválidos"),
        @ApiResponse(responseCode = "404", description = "Pedido no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<OrderDTO> updateOrder(
            @Parameter(description = "ID del pedido a actualizar", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del pedido")
            @Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.update(id, orderDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar pedido", description = "Elimina un pedido del sistema por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pedido eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Pedido no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", descripción = "Acceso prohibido")
    })
    public ResponseEntity<Void> deleteOrder(
            @Parameter(description = "ID del pedido a eliminar", example = "1")
            @PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Obtener pedidos por cliente", description = "Retorna todos los pedidos de un cliente específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de pedidos del cliente obtenida exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Page.class))),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<Page<OrderDTO>> getOrdersByCustomer(
            @Parameter(description = "ID del cliente", example = "1")
            @PathVariable Long customerId,
            @Parameter(description = "Parámetros de paginación y ordenamiento")
            @PageableDefault(size = 10, sort = "orderDate") Pageable pageable) {
        Page<OrderDTO> orders = orderService.findByCustomerId(customerId, pageable);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Obtener pedidos por estado", description = "Retorna todos los pedidos con un estado específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de pedidos con el estado especificado obtenida exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Page.class))),
        @ApiResponse(responseCode = "400", description = "Estado inválido"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<Page<OrderDTO>> getOrdersByStatus(
            @Parameter(description = "Estado del pedido (PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED)", 
                       example = "PENDING")
            @PathVariable String status,
            @Parameter(description = "Parámetros de paginación y ordenamiento")
            @PageableDefault(size = 10, sort = "orderDate") Pageable pageable) {
        Page<OrderDTO> orders = orderService.findByStatus(status, pageable);
        return ResponseEntity.ok(orders);
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Actualizar estado del pedido", description = "Cambia el estado de un pedido existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estado del pedido actualizado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = OrderDTO.class))),
        @ApiResponse(responseCode = "400", description = "Estado inválido"),
        @ApiResponse(responseCode = "404", description = "Pedido no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<OrderDTO> updateOrderStatus(
            @Parameter(description = "ID del pedido", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevo estado del pedido")
            @RequestParam String status) {
        OrderDTO updatedOrder = orderService.updateStatus(id, status);
        return ResponseEntity.ok(updatedOrder);
    }
}