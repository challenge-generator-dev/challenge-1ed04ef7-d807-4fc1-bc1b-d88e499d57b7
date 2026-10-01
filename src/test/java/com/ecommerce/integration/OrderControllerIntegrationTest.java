package com.ecommerce.integration;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.security.JwtTokenUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private String adminToken;
    private String userToken;
    private Customer testCustomer;
    private Order testOrder;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();

        testCustomer = new Customer();
        testCustomer.setFirstName("Juan");
        testCustomer.setLastName("Perez");
        testCustomer.setEmail("juan.perez@test.com");
        testCustomer.setPassword("password123");
        testCustomer.setPhone("+1234567890");
        testCustomer.setAddressLine1("Calle Principal 123");
        testCustomer.setCity("Madrid");
        testCustomer.setState("Madrid");
        testCustomer.setPostalCode("28001");
        testCustomer.setCountry("España");
        testCustomer = customerRepository.save(testCustomer);

        Product product = new Product();
        product.setName("Laptop");
        product.setDescription("Laptop de alta gama");
        product.setPrice(new BigDecimal("999.99"));
        product.setStock(10);
        product.setImageUrl("https://example.com/laptop.jpg");
        product = productRepository.save(product);

        testOrder = new Order();
        testOrder.setOrderDate(LocalDateTime.now());
        testOrder.setTotalAmount(new BigDecimal("999.99"));
        testOrder.setStatus("PENDING");
        testOrder.setCustomer(testCustomer);
        Set<Product> products = new HashSet<>();
        products.add(product);
        testOrder.setProducts(products);
        testOrder = orderRepository.save(testOrder);

        adminToken = jwtTokenUtil.generateToken(testCustomer.getEmail());
        userToken = jwtTokenUtil.generateToken(testCustomer.getEmail());
    }

    @Test
    void testGetAllOrders() throws Exception {
        mockMvc.perform(get("/api/orders")
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    void testGetOrderById() throws Exception {
        mockMvc.perform(get("/api/orders/" + testOrder.getId())
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testOrder.getId()));
    }

    @Test
    void testGetOrderByIdNotFound() throws Exception {
        mockMvc.perform(get("/api/orders/99999")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateOrder() throws Exception {
        String orderJson = "{\"customerId\":" + testCustomer.getId() + ",\"items\":[],\"status\":\"PENDING\"}";

        mockMvc.perform(post("/api/orders")
                        .header("Authorization", "Bearer " + userToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateOrder() throws Exception {
        String updateJson = "{\"status\":\"COMPLETED\"}";

        mockMvc.perform(put("/api/orders/" + testOrder.getId())
                        .header("Authorization", "Bearer " + adminToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("COMPLETED"));
    }

    @Test
    void testDeleteOrder() throws Exception {
        mockMvc.perform(delete("/api/orders/" + testOrder.getId())
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/orders/" + testOrder.getId())
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetOrdersByCustomer() throws Exception {
        mockMvc.perform(get("/api/orders/customer/" + testCustomer.getId())
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    void testGetOrdersByStatus() throws Exception {
        mockMvc.perform(get("/api/orders/status/PENDING")
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    void testGetOrdersWithPagination() throws Exception {
        mockMvc.perform(get("/api/orders")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "orderDate")
                        .param("sortDir", "DESC")
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.totalElements").isNumber())
                .andExpect(jsonPath("$.totalPages").isNumber());
    }

    @Test
    void testUnauthorizedAccess() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testForbiddenAccess() throws Exception {
        mockMvc.perform(post("/api/orders")
                        .header("Authorization", "Bearer " + userToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isForbidden());
    }
}