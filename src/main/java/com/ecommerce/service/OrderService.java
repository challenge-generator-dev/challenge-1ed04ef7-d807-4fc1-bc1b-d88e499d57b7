package com.ecommerce.service;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        validateOrderData(orderDTO);
        
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDIENTE");
        order.setTotalAmount(calculateTotalAmount(orderDTO));
        
        Order savedOrder = orderRepository.save(order);
        return mapToDTO(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + id));
        return mapToDTO(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<OrderDTO> getOrdersPaged(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(this::mapToDTO);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO updateOrderStatus(Long id, String newStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + id));
        
        validateStatus(newStatus);
        order.setStatus(newStatus);
        
        Order updatedOrder = orderRepository.save(order);
        return mapToDTO(updatedOrder);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + id));
        
        validateOrderData(orderDTO);
        
        existingOrder.setStatus(orderDTO.getStatus());
        existingOrder.setTotalAmount(orderDTO.getTotalAmount());
        
        Order updatedOrder = orderRepository.save(existingOrder);
        return mapToDTO(updatedOrder);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido no encontrado con ID: " + id);
        }
        orderRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public BigDecimal getTotalSalesAmount() {
        return orderRepository.findAll().stream()
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transactional(readOnly = true)
    public Long getOrderCountByStatus(String status) {
        return orderRepository.countByStatus(status);
    }

    private void validateOrderData(OrderDTO orderDTO) {
        if (orderDTO.getStatus() != null && !isValidStatus(orderDTO.getStatus())) {
            throw new IllegalArgumentException("Estado de pedido inválido");
        }
    }

    private void validateStatus(String status) {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Estado de pedido inválido. Estados válidos: PENDIENTE, PROCESANDO, ENVIADO, ENTREGADO, CANCELADO");
        }
    }

    private boolean isValidStatus(String status) {
        return status != null && (
            "PENDIENTE".equals(status) ||
            "PROCESANDO".equals(status) ||
            "ENVIADO".equals(status) ||
            "ENTREGADO".equals(status) ||
            "CANCELADO".equals(status)
        );
    }

    private BigDecimal calculateTotalAmount(OrderDTO orderDTO) {
        if (orderDTO.getTotalAmount() != null) {
            return orderDTO.getTotalAmount();
        }
        return BigDecimal.ZERO;
    }

    private OrderDTO mapToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        return dto;
    }
}