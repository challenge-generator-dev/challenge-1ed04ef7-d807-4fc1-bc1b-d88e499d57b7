package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;
import com.ecommerce.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Disabled("Superficie de práctica - completar las pruebas")
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order testOrder;
    private Customer testCustomer;
    private Product testProduct;
    private OrderItem testOrderItem;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer();
        testCustomer.setId(1L);
        testCustomer.setFirstName("John");
        testCustomer.setLastName("Doe");
        testCustomer.setEmail("john.doe@example.com");

        testProduct = new Product();
        testProduct.setId(1L);
        testProduct.setName("Test Product");
        testProduct.setPrice(new BigDecimal("99.99"));
        testProduct.setStock(10);

        testOrderItem = new OrderItem();
        testOrderItem.setId(1L);
        testOrderItem.setProduct(testProduct);
        testOrderItem.setQuantity(2);
        testOrderItem.setPrice(new BigDecimal("99.99"));

        testOrder = new Order();
        testOrder.setId(1L);
        testOrder.setOrderDate(LocalDateTime.now());
        testOrder.setTotalAmount(new BigDecimal("199.98"));
        testOrder.setStatus("PENDING");
        testOrder.setCustomer(testCustomer);
        testOrder.setItems(new HashSet<>(Arrays.asList(testOrderItem)));
        testOrder.setProducts(new HashSet<>(Arrays.asList(testProduct)));
    }

    // TODO: Implementar test para obtener todos los pedidos
    @org.junit.jupiter.api.Test
    void testFindAll_ReturnsAllOrders() {
        // Arrange
        List<Order> orders = Arrays.asList(testOrder);
        when(orderRepository.findAll()).thenReturn(orders);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para obtener pedido por ID existente
    @org.junit.jupiter.api.Test
    void testFindById_ExistingId_ReturnsOrder() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(testOrder));

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para obtener pedido por ID no existente
    @org.junit.jupiter.api.Test
    void testFindById_NonExistingId_ThrowsException() {
        // Arrange
        when(orderRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        // TODO: Verificar que lanza ResourceNotFoundException
    }

    // TODO: Implementar test para crear pedido
    @org.junit.jupiter.api.Test
    void testSave_ValidOrder_ReturnsSavedOrder() {
        // Arrange
        when(orderRepository.save(any(Order.class))).thenReturn(testOrder);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para actualizar estado de pedido
    @org.junit.jupiter.api.Test
    void testUpdateStatus_ExistingOrder_ReturnsUpdatedOrder() {
        // Arrange
        Order updatedOrder = new Order();
        updatedOrder.setId(1L);
        updatedOrder.setStatus("CONFIRMED");

        when(orderRepository.findById(1L)).thenReturn(Optional.of(testOrder));
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para obtener pedidos por cliente
    @org.junit.jupiter.api.Test
    void testFindByCustomerId_ReturnsCustomerOrders() {
        // Arrange
        List<Order> orders = Arrays.asList(testOrder);
        when(orderRepository.findByCustomerId(1L)).thenReturn(orders);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }
}