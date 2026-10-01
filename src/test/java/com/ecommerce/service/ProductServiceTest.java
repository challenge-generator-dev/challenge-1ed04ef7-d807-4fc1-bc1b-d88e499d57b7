package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Disabled("Superficie de práctica - completar las pruebas")
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product();
        testProduct.setId(1L);
        testProduct.setName("Test Product");
        testProduct.setDescription("Test Description");
        testProduct.setPrice(new BigDecimal("99.99"));
        testProduct.setStock(10);
        testProduct.setImageUrl("https://example.com/image.jpg");
    }

    // TODO: Implementar test para obtener todos los productos
    // Given: existen productos en la base de datos
    // When: se llama al método findAll()
    // Then: retorna lista de productos
    @org.junit.jupiter.api.Test
    void testFindAll_ReturnsAllProducts() {
        // Arrange
        List<Product> products = Arrays.asList(testProduct);
        when(productRepository.findAll()).thenReturn(products);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para obtener producto por ID existente
    @org.junit.jupiter.api.Test
    void testFindById_ExistingId_ReturnsProduct() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para obtener producto por ID no existente
    @org.junit.jupiter.api.Test
    void testFindById_NonExistingId_ThrowsException() {
        // Arrange
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        // TODO: Verificar que lanza ResourceNotFoundException
    }

    // TODO: Implementar test para crear producto
    @org.junit.jupiter.api.Test
    void testSave_ValidProduct_ReturnsSavedProduct() {
        // Arrange
        when(productRepository.save(any(Product.class))).thenReturn(testProduct);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para actualizar producto existente
    @org.junit.jupiter.api.Test
    void testUpdate_ExistingProduct_ReturnsUpdatedProduct() {
        // Arrange
        Product updatedProduct = new Product();
        updatedProduct.setId(1L);
        updatedProduct.setName("Updated Name");
        updatedProduct.setDescription("Updated Description");
        updatedProduct.setPrice(new BigDecimal("149.99"));
        updatedProduct.setStock(20);

        when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        // TODO: Verificar resultados
    }

    // TODO: Implementar test para eliminar producto
    @org.junit.jupiter.api.Test
    void testDelete_ExistingId_DeletesProduct() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        doNothing().when(productRepository).delete(testProduct);

        // Act
        // TODO: Llamar al método del servicio

        // Assert
        verify(productRepository, times(1)).delete(testProduct);
    }
}