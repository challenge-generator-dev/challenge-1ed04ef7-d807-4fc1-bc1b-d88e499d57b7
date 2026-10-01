# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Desarrollo de una API REST para Gestión de Productos y Pedidos**.

| | |
|---|---|
| Tema | arquitectura-de-api-rest-en-e-commerce |
| Nivel | junior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.3 |
| Patron arquitectonico | capas estándar (controller-service-repository) |
| Tiempo estimado | 20 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.3.0
- org.springframework.boot:spring-boot-starter-data-jpa 3.3.0
- org.springframework.boot:spring-boot-starter-security 3.3.0
- io.jsonwebtoken:jjwt-api 0.11.5
- io.jsonwebtoken:jjwt-impl 0.11.5
- io.jsonwebtoken:jjwt-jackson 0.11.5
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0
- org.projectlombok:lombok 1.18.30
- org.mapstruct:mapstruct 1.5.5.Final
- org.postgresql:postgresql 42.6.0
- org.springframework.boot:spring-boot-starter-test n/a
- org.springframework.security:spring-security-test n/a

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición del Modelo de Datos**: Modelo de datos completo con entidades y relaciones definidas.
- **Fase 2 — Implementación de la Arquitectura en Capas**: Arquitectura en capas implementada con controladores, servicios y repositorios funcionales.
- **Fase 3 — Autenticación y Autorización**: Sistema de autenticación y autorización funcional con JWT y Spring Security.
- **Fase 4 — Documentación y Manejo de Errores**: Documentación completa de la API y manejo centralizado de errores funcional.
- **Fase 5 — Validación de Entradas y Paginación**: Validación de entradas funcional y paginación y ordenamiento de resultados implementados.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `Dockerfile` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- [ ] `docker-compose.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- [ ] `src/main/java/com/ecommerce/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/exception/UnauthorizedException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/dto/JwtResponse.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/dto/JwtRequest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/controller/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/service/AuthService.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (126)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/ecommerce/EcommerceApplication.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/dto/ProductDTO.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/dto/OrderDTO.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/dto/CustomerDTO.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/dto/JwtResponse.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/dto/JwtRequest.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/config/OpenApiConfig.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/controller/AuthController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java` — `JwtTokenUtil.getUsernameFromToken`
      Se invoca `getUsernameFromToken` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java` — `JwtTokenUtil.getRolesFromToken`
      Se invoca `getRolesFromToken` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.findAll`
      Se invoca `findAll` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.findById`
      Se invoca `findById` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.save`
      Se invoca `save` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.update`
      Se invoca `update` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.delete`
      Se invoca `delete` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.searchByName`
      Se invoca `searchByName` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findAll`
      Se invoca `findAll` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findById`
      Se invoca `findById` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.save`
      Se invoca `save` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.update`
      Se invoca `update` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.delete`
      Se invoca `delete` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findByCustomerId`
      Se invoca `findByCustomerId` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findByStatus`
      Se invoca `findByStatus` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.updateStatus`
      Se invoca `updateStatus` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/controller/AuthController.java` — `AuthService.authenticate`
      Se invoca `authenticate` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setStock`
      Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setImageUrl`
      Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findByNameContainingIgnoreCase`
      Se invoca `findByNameContainingIgnoreCase` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findByPriceBetween`
      Se invoca `findByPriceBetween` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findByStockGreaterThan`
      Se invoca `findByStockGreaterThan` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.existsById`
      Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.deleteById`
      Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getId`
      Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getName`
      Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getDescription`
      Se invoca `getDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getPrice`
      Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getStock`
      Se invoca `getStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getImageUrl`
      Se invoca `getImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.setOrderDate`
      Se invoca `setOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.setStatus`
      Se invoca `setStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.setTotalAmount`
      Se invoca `setTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.save`
      Se invoca `save` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.findById`
      Se invoca `findById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.findAll`
      Se invoca `findAll` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.existsById`
      Se invoca `existsById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.deleteById`
      Se invoca `deleteById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.countByStatus`
      Se invoca `countByStatus` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getId`
      Se invoca `getId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getOrderDate`
      Se invoca `getOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getTotalAmount`
      Se invoca `getTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getStatus`
      Se invoca `getStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setId`
      Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setStock`
      Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setImageUrl`
      Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setId`
      Se invoca `setId` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setFirstName`
      Se invoca `setFirstName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setLastName`
      Se invoca `setLastName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setEmail`
      Se invoca `setEmail` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setId`
      Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setStock`
      Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setId`
      Se invoca `setId` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setProduct`
      Se invoca `setProduct` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setQuantity`
      Se invoca `setQuantity` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setPrice`
      Se invoca `setPrice` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setId`
      Se invoca `setId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setOrderDate`
      Se invoca `setOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setTotalAmount`
      Se invoca `setTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setStatus`
      Se invoca `setStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setCustomer`
      Se invoca `setCustomer` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setItems`
      Se invoca `setItems` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setProducts`
      Se invoca `setProducts` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderRepository.findAll`
      Se invoca `findAll` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderRepository.findById`
      Se invoca `findById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderRepository.save`
      Se invoca `save` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `ProductRepository.deleteAll`
      Se invoca `deleteAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setStock`
      Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setImageUrl`
      Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `OrderRepository.deleteAll`
      Se invoca `deleteAll` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `CustomerRepository.deleteAll`
      Se invoca `deleteAll` sobre `CustomerRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `ProductRepository.deleteAll`
      Se invoca `deleteAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setFirstName`
      Se invoca `setFirstName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setLastName`
      Se invoca `setLastName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setEmail`
      Se invoca `setEmail` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setPassword`
      Se invoca `setPassword` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setPhone`
      Se invoca `setPhone` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setAddressLine1`
      Se invoca `setAddressLine1` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setCity`
      Se invoca `setCity` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setState`
      Se invoca `setState` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setPostalCode`
      Se invoca `setPostalCode` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setCountry`
      Se invoca `setCountry` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `CustomerRepository.save`
      Se invoca `save` sobre `CustomerRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setName`
      Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setDescription`
      Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setPrice`
      Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setStock`
      Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setImageUrl`
      Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setOrderDate`
      Se invoca `setOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setTotalAmount`
      Se invoca `setTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setStatus`
      Se invoca `setStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setCustomer`
      Se invoca `setCustomer` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setProducts`
      Se invoca `setProducts` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `OrderRepository.save`
      Se invoca `save` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.getEmail`
      Se invoca `getEmail` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.getId`
      Se invoca `getId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.getId`
      Se invoca `getId` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (35)

- `pom.xml`
- `src/main/java/com/ecommerce/EcommerceApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/ecommerce/model/Product.java`
- `src/main/java/com/ecommerce/model/Order.java`
- `src/main/java/com/ecommerce/model/Customer.java`
- `src/main/java/com/ecommerce/model/OrderItem.java`
- `src/main/java/com/ecommerce/dto/ProductDTO.java`
- `src/main/java/com/ecommerce/dto/OrderDTO.java`
- `src/main/java/com/ecommerce/dto/CustomerDTO.java`
- `src/main/java/com/ecommerce/dto/JwtResponse.java`
- `src/main/java/com/ecommerce/dto/JwtRequest.java`
- `src/main/java/com/ecommerce/repository/ProductRepository.java`
- `src/main/java/com/ecommerce/repository/OrderRepository.java`
- `src/main/java/com/ecommerce/repository/CustomerRepository.java`
- `src/main/java/com/ecommerce/config/OpenApiConfig.java`
- `src/main/java/com/ecommerce/config/SecurityConfig.java`
- `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java`
- `src/main/java/com/ecommerce/security/JwtTokenUtil.java`
- `src/main/java/com/ecommerce/exception/GlobalExceptionHandler.java`
- `src/main/java/com/ecommerce/exception/ResourceNotFoundException.java`
- `src/main/java/com/ecommerce/exception/UnauthorizedException.java`
- `src/main/java/com/ecommerce/controller/ProductController.java`
- `src/main/java/com/ecommerce/controller/OrderController.java`
- `src/main/java/com/ecommerce/controller/AuthController.java`
- `src/main/java/com/ecommerce/service/ProductService.java`
- `src/main/java/com/ecommerce/service/OrderService.java`
- `src/main/java/com/ecommerce/service/AuthService.java`
- `src/main/resources/data.sql`
- `Dockerfile`
- `docker-compose.yml`
- `src/test/java/com/ecommerce/service/ProductServiceTest.java`
- `src/test/java/com/ecommerce/service/OrderServiceTest.java`
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java`
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/ecommerce`
- `src/main/java/com/ecommerce/config`
- `src/main/java/com/ecommerce/controller`
- `src/main/java/com/ecommerce/dto`
- `src/main/java/com/ecommerce/exception`
- `src/main/java/com/ecommerce/model`
- `src/main/java/com/ecommerce/repository`
- `src/main/java/com/ecommerce/security`
- `src/main/java/com/ecommerce/service`
- `src/main/resources`
- `src/test/java/com/ecommerce/service`
- `src/test/java/com/ecommerce/integration`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (controller-service-repository)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Desarrollar una API REST empresarial con Spring Boot 3 para la gestión de productos y pedidos en un e-commerce. El sistema debe incluir: arquitectura en capas con controladores REST, servicios de negocio y repositorios JPA; modelado de datos con entidades Product, Order y Customer usando relaciones OneToMany y ManyToMany con Hibernate; autenticación y autorización basada en JWT con Spring Security, incluyendo roles de ADMIN y USER con acceso diferenciado por endpoint; documentación automática con OpenAPI 3.0 y Swagger UI accesible en /api-docs; manejo centralizado de errores con @ControllerAdvice y respuestas estandarizadas en formato JSON; validación de entradas con Bean Validation usando @Valid, @NotNull y @Size; paginación y ordenamiento de resultados en los endpoints de listado usando Pageable; pruebas unitarias con JUnit 5 y Mockito cubriendo la capa de servicio al menos al 80%; pruebas de integración con @SpringBootTest verificando los flujos principales; y containerización con Docker usando Dockerfile multi-stage optimizado para producción. El desarrollador debe implementar el módulo completo desde la capa de persistencia hasta los controladores REST, aplicando principios SOLID y clean code en cada capa.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
