package com.ecommerce.integration;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Disabled("Superficie de práctica - completar las pruebas")
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();

        testProduct = new Product();
        testProduct.setName("Integration Test Product");
        testProduct.setDescription("Test Description for Integration");
        testProduct.setPrice(new BigDecimal("199.99"));
        testProduct.setStock(50);
        testProduct.setImageUrl("https://example.com/integration-test.jpg");

        testProduct = productRepository.save(testProduct);
    }

    // TODO: Implementar test de integración para GET /api/products
    @Test
    @WithMockUser(roles = "USER")
    void testGetAllProducts_ReturnsProductList() throws Exception {
        // Given: existe un producto en la base de datos
        // When: cliente hace GET a /api/products
        // Then: retorna status 200 y lista de productos

        // TODO: Completar con mockMvc.perform(get("/api/products"))
        // TODO: Y verificar status, contentType y jsonPath
    }

    // TODO: Implementar test de integración para GET /api/products/{id}
    @Test
    @WithMockUser(roles = "USER")
    void testGetProductById_ExistingId_ReturnsProduct() throws Exception {
        // TODO: Completar test
    }

    // TODO: Implementar test para producto no encontrado
    @Test
    @WithMockUser(roles = "USER")
    void testGetProductById_NonExistingId_Returns404() throws Exception {
        // TODO: Completar test
    }

    // TODO: Implementar test para crear producto (POST)
    @Test
    @WithMockUser(roles = "ADMIN")
    void testCreateProduct_ValidData_ReturnsCreated() throws Exception {
        // TODO: Completar con JSON del producto
    }

    // TODO: Implementar test para actualizar producto
    @Test
    @WithMockUser(roles = "ADMIN")
    void testUpdateProduct_ValidData_ReturnsUpdated() throws Exception {
        // TODO: Completar test
    }

    // TODO: Implementar test para eliminar producto
    @Test
    @WithMockUser(roles = "ADMIN")
    void testDeleteProduct_ExistingId_ReturnsNoContent() throws Exception {
        // TODO: Completar test
    }

    // TODO: Implementar test de acceso denegado para usuario sin rol
    @Test
    void testGetAllProducts_Unauthenticated_Returns401() throws Exception {
        // TODO: Completar test sin @WithMockUser
    }
}