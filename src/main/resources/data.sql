-- Inicialización de datos de ejemplo para la base de datos
ecommerce=# \c ecommerce

-- Insertar clientes de ejemplo
INSERT INTO customer (id, first_name, last_name, email, password, phone, address_line1, address_line2, city, state, postal_code, country) VALUES
(1, 'Juan', 'Pérez', 'juan.perez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '+34612345678', 'Calle Mayor 123', NULL, 'Madrid', 'Madrid', '28013', 'España'),
(2, 'María', 'García', 'maria.garcia@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '+34987654321', 'Avenida Barcelona 45', 'Portal 2, 3ºB', 'Barcelona', 'Cataluña', '08010', 'España'),
(3, 'Carlos', 'López', 'carlos.lopez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '+34555443322', 'Plaza España 10', NULL, 'Valencia', 'Valencia', '46001', 'España');

-- Insertar productos de ejemplo
INSERT INTO product (id, name, description, price, stock, image_url) VALUES
(1, 'Portátil UltraBook 15', 'Portátil de 15 pulgadas con procesador Intel i7, 16GB RAM y SSD 512GB', 899.99, 25, 'https://ejemplo.com/img/ultrabook15.jpg'),
(2, 'Smartphone Pro Max', 'Teléfono móvil de alta gama con pantalla AMOLED de 6.7 pulgadas y cámara de 108MP', 1099.00, 50, 'https://ejemplo.com/img/smartphone-pro.jpg'),
(3, 'Auriculares Inalámbricos', 'Auriculares con cancelación activa de ruido y batería de 30 horas', 199.50, 100, 'https://ejemplo.com/img/auriculares.jpg'),
(4, 'Reloj Inteligente Fit', 'Smartwatch con monitor de frecuencia cardíaca, GPS y resistencia al agua 5ATM', 249.99, 75, 'https://ejemplo.com/img/smartwatch-fit.jpg'),
(5, 'Tableta Graphics 10', 'Tableta de 10 pulgadas con stylus incluido para diseño gráfico', 449.00, 30, 'https://ejemplo.com/img/tableta-graphics.jpg'),
(6, 'Cámara Digital Alpha', 'Cámara mirrorless de 24MP con grabación 4K', 1299.00, 15, 'https://ejemplo.com/img/camara-alpha.jpg'),
(7, 'Consola GameBox Pro', 'Consola de videojuegos de última generación con 1TB de almacenamiento', 499.99, 40, 'https://ejemplo.com/img/gamebox-pro.jpg'),
(8, 'Altavoz Bluetooth Bass', 'Altavoz portátil con sonido surround y resistencia IPX7', 89.99, 120, 'https://ejemplo.com/img/altavoz-bass.jpg');

-- Insertar pedidos de ejemplo
INSERT INTO order_table (id, order_date, total_amount, status, customer_id) VALUES
(1, '2024-01-15 10:30:00', 1099.00, 'COMPLETADO', 1),
(2, '2024-01-18 14:45:00', 289.49, 'COMPLETADO', 1),
(3, '2024-01-20 09:15:00', 1748.99, 'EN_PROCESO', 2),
(4, '2024-01-22 16:20:00', 449.00, 'PENDIENTE', 3),
(5, '2024-01-25 11:00:00', 589.98, 'COMPLETADO', 2);

-- Insertar elementos de pedido (relación muchos a muchos entre pedidos y productos)
INSERT INTO order_items (order_id, products_id, quantity, unit_price) VALUES
(1, 2, 1, 1099.00),
(2, 3, 1, 199.50),
(2, 8, 1, 89.99),
(3, 1, 1, 899.99),
(3, 4, 1, 249.00),
(3, 8, 2, 89.99),
(4, 5, 1, 449.00),
(5, 7, 1, 499.99),
(5, 8, 1, 89.99);