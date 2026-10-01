# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `Dockerfile` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `docker-compose.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `src/main/java/com/ecommerce/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/exception/UnauthorizedException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/dto/JwtResponse.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/dto/JwtRequest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/controller/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/service/AuthService.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/ecommerce/EcommerceApplication.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/dto/ProductDTO.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/dto/OrderDTO.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/dto/CustomerDTO.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/dto/JwtResponse.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/dto/JwtRequest.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/controller/ProductController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/controller/OrderController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/controller/AuthController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java` — `JwtTokenUtil.getUsernameFromToken`: Se invoca `getUsernameFromToken` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java` — `JwtTokenUtil.getRolesFromToken`: Se invoca `getRolesFromToken` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.findAll`: Se invoca `findAll` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.findById`: Se invoca `findById` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.save`: Se invoca `save` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.update`: Se invoca `update` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.delete`: Se invoca `delete` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/ProductController.java` — `ProductService.searchByName`: Se invoca `searchByName` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findAll`: Se invoca `findAll` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findById`: Se invoca `findById` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.save`: Se invoca `save` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.update`: Se invoca `update` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.delete`: Se invoca `delete` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findByCustomerId`: Se invoca `findByCustomerId` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.findByStatus`: Se invoca `findByStatus` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/OrderController.java` — `OrderService.updateStatus`: Se invoca `updateStatus` sobre `OrderService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/controller/AuthController.java` — `AuthService.authenticate`: Se invoca `authenticate` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setStock`: Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.setImageUrl`: Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findByNameContainingIgnoreCase`: Se invoca `findByNameContainingIgnoreCase` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findByPriceBetween`: Se invoca `findByPriceBetween` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.findByStockGreaterThan`: Se invoca `findByStockGreaterThan` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getId`: Se invoca `getId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getName`: Se invoca `getName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getDescription`: Se invoca `getDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getPrice`: Se invoca `getPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getStock`: Se invoca `getStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/ProductService.java` — `Product.getImageUrl`: Se invoca `getImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.setOrderDate`: Se invoca `setOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.setStatus`: Se invoca `setStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.setTotalAmount`: Se invoca `setTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.save`: Se invoca `save` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.findById`: Se invoca `findById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.findAll`: Se invoca `findAll` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.existsById`: Se invoca `existsById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.deleteById`: Se invoca `deleteById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `OrderRepository.countByStatus`: Se invoca `countByStatus` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getId`: Se invoca `getId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getOrderDate`: Se invoca `getOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getTotalAmount`: Se invoca `getTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/service/OrderService.java` — `Order.getStatus`: Se invoca `getStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setId`: Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setStock`: Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `Product.setImageUrl`: Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setId`: Se invoca `setId` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setFirstName`: Se invoca `setFirstName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setLastName`: Se invoca `setLastName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Customer.setEmail`: Se invoca `setEmail` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setId`: Se invoca `setId` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Product.setStock`: Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setId`: Se invoca `setId` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setProduct`: Se invoca `setProduct` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setQuantity`: Se invoca `setQuantity` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderItem.setPrice`: Se invoca `setPrice` sobre `OrderItem`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setId`: Se invoca `setId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setOrderDate`: Se invoca `setOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setTotalAmount`: Se invoca `setTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setStatus`: Se invoca `setStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setCustomer`: Se invoca `setCustomer` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setItems`: Se invoca `setItems` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `Order.setProducts`: Se invoca `setProducts` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderRepository.findAll`: Se invoca `findAll` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderRepository.findById`: Se invoca `findById` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/service/OrderServiceTest.java` — `OrderRepository.save`: Se invoca `save` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `ProductRepository.deleteAll`: Se invoca `deleteAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setStock`: Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `Product.setImageUrl`: Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `OrderRepository.deleteAll`: Se invoca `deleteAll` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `CustomerRepository.deleteAll`: Se invoca `deleteAll` sobre `CustomerRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `ProductRepository.deleteAll`: Se invoca `deleteAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setFirstName`: Se invoca `setFirstName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setLastName`: Se invoca `setLastName` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setEmail`: Se invoca `setEmail` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setPassword`: Se invoca `setPassword` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setPhone`: Se invoca `setPhone` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setAddressLine1`: Se invoca `setAddressLine1` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setCity`: Se invoca `setCity` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setState`: Se invoca `setState` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setPostalCode`: Se invoca `setPostalCode` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.setCountry`: Se invoca `setCountry` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `CustomerRepository.save`: Se invoca `save` sobre `CustomerRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setName`: Se invoca `setName` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setDescription`: Se invoca `setDescription` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setPrice`: Se invoca `setPrice` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setStock`: Se invoca `setStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Product.setImageUrl`: Se invoca `setImageUrl` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setOrderDate`: Se invoca `setOrderDate` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setTotalAmount`: Se invoca `setTotalAmount` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setStatus`: Se invoca `setStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setCustomer`: Se invoca `setCustomer` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.setProducts`: Se invoca `setProducts` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `OrderRepository.save`: Se invoca `save` sobre `OrderRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.getEmail`: Se invoca `getEmail` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Order.getId`: Se invoca `getId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java` — `Customer.getId`: Se invoca `getId` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Desarrollar una API REST empresarial con Spring Boot 3 para la gestión de productos y pedidos en un e-commerce. El sistema debe incluir: arquitectura en capas con controladores REST, servicios de negocio y repositorios JPA; modelado de datos con entidades Product, Order y Customer usando relaciones OneToMany y ManyToMany con Hibernate; autenticación y autorización basada en JWT con Spring Security, incluyendo roles de ADMIN y USER con acceso diferenciado por endpoint; documentación automática con OpenAPI 3.0 y Swagger UI accesible en /api-docs; manejo centralizado de errores con @ControllerAdvice y respuestas estandarizadas en formato JSON; validación de entradas con Bean Validation usando @Valid, @NotNull y @Size; paginación y ordenamiento de resultados en los endpoints de listado usando Pageable; pruebas unitarias con JUnit 5 y Mockito cubriendo la capa de servicio al menos al 80%; pruebas de integración con @SpringBootTest verificando los flujos principales; y containerización con Docker usando Dockerfile multi-stage optimizado para producción. El desarrollador debe implementar el módulo completo desde la capa de persistencia hasta los controladores REST, aplicando principios SOLID y clean code en cada capa.

### Reto
- Tema: arquitectura-de-api-rest-en-e-commerce
- Seniority: junior-l2
- Tipo: practical
- Título: Desarrollo de una API REST para Gestión de Productos y Pedidos
- Tiempo estimado: 20 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del Modelo de Datos — objetivo: Establecer el modelo de datos para productos, pedidos y clientes, incluyendo relaciones entre entidades. — entregable (NO resolver): Modelo de datos completo con entidades y relaciones definidas.
- Fase 2: Implementación de la Arquitectura en Capas — objetivo: Implementar la arquitectura en capas con controladores REST, servicios de negocio y repositorios JPA. — entregable (NO resolver): Arquitectura en capas implementada con controladores, servicios y repositorios funcionales.
- Fase 3: Autenticación y Autorización — objetivo: Implementar la autenticación y autorización basada en JWT con Spring Security. — entregable (NO resolver): Sistema de autenticación y autorización funcional con JWT y Spring Security.
- Fase 4: Documentación y Manejo de Errores — objetivo: Documentar la API con OpenAPI y manejar los errores de forma centralizada. — entregable (NO resolver): Documentación completa de la API y manejo centralizado de errores funcional.
- Fase 5: Validación de Entradas y Paginación — objetivo: Implementar la validación de entradas y la paginación y ordenamiento de resultados. — entregable (NO resolver): Validación de entradas funcional y paginación y ordenamiento de resultados implementados.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.0</version>
        <relativePath/>
    </parent>

    <groupId>com.ecommerce</groupId>
    <artifactId>ecommerce-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>ecommerce-api</name>
    <description>API REST para gestion de productos y pedidos en e-commerce</description>

    <properties>
        <java.version>17</java.version>
        <mapstruct.version>1.5.5.Final</mapstruct.version>
        <lombok.version>1.18.30</lombok.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>

        <!-- OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>provided</scope>
        </dependency>

        <!-- MapStruct -->
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>${mapstruct.version}</version>
        </dependency>

        <!-- PostgreSQL -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                            <version>${mapstruct.version}</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/ecommerce/EcommerceApplication.java ===
package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableConfigurationProperties
public class EcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("API E-commerce")
                    .version("1.0")
                    .description("Documentación de la API para gestión de productos y pedidos")
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

    @Bean
    public org.springframework.boot.autoconfigure.security.servlet.SecurityFilterChain securityFilterChain(
            org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)
            );

        return http.build();
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  servlet:
    context-path: /api

spring:
  application:
    name: ecommerce-api
  datasource:
    url: jdbc:postgresql://localhost:5432/ecommerce
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  security:
    user:
      name: admin
      password: admin
      roles: ADMIN

jwt:
  secret: MiClaveSecretaParaGenerarJWTQueDebeSerMuyLargaYCompleja1234567890
  expiration: 86400000

springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: method
    tagsSorter: alpha
    doc-expansion: none

// === ARCHIVO: src/main/java/com/ecommerce/model/Product.java ===
package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/model/Order.java ===
package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            orderDate = LocalDateTime.now();
        }
        if (status == null) {
            status = "PENDING";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id != null && id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/model/Customer.java ===
package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column
    private String city;

    @Column
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private String country;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id != null && id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/model/OrderItem.java ===
package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/dto/ProductDTO.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/dto/OrderDTO.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/dto/CustomerDTO.java ===
package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para transferencia de datos de clientes")
public class CustomerDTO {

    @Schema(description = "Identificador único del cliente", example = "1")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String lastName;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido")
    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@ejemplo.com")
    private String email;

    @Size(min = 6, max = 20, message = "El teléfono debe tener entre 6 y 20 caracteres")
    @Schema(description = "Teléfono del cliente", example = "+1234567890")
    private String phone;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 255, message = "La dirección no puede exceder 255 caracteres")
    @Schema(description = "Dirección principal del cliente", example = "Calle Principal 123")
    private String addressLine1;

    @Size(max = 255, message = "La dirección adicional no puede exceder 255 caracteres")
    @Schema(description = "Dirección adicional del cliente", example = "Apartamento 4B")
    private String addressLine2;

    @NotBlank(message = "La ciudad es obligatoria")
    @Size(max = 100, message = "La ciudad no puede exceder 100 caracteres")
    @Schema(description = "Ciudad del cliente", example = "Madrid")
    private String city;

    @NotBlank(message = "El estado o provincia es obligatorio")
    @Size(max = 100, message = "El estado no puede exceder 100 caracteres")
    @Schema(description = "Estado o provincia del cliente", example = "Comunidad de Madrid")
    private String state;

    @NotBlank(message = "El código postal es obligatorio")
    @Size(min = 3, max = 20, message = "El código postal debe tener entre 3 y 20 caracteres")
    @Schema(description = "Código postal del cliente", example = "28001")
    private String postalCode;

    @NotBlank(message = "El país es obligatorio")
    @Size(max = 100, message = "El país no puede exceder 100 caracteres")
    @Schema(description = "País del cliente", example = "España")
    private String country;

    @Schema(description = "Conjunto de pedidos asociados al cliente")
    private Set<Long> orderIds;
}

// === ARCHIVO: src/main/java/com/ecommerce/dto/JwtResponse.java ===
package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para la respuesta de autenticación con el token JWT")
public class JwtResponse {

    @Schema(description = "Token JWT para autenticación", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    @Schema(description = "Tipo de token", example = "Bearer")
    private String type;

    @Schema(description = "Nombre de usuario", example = "usuario@ejemplo.com")
    private String username;

    @Schema(description = "Roles del usuario", example = "[ROLE_USER, ROLE_ADMIN]")
    private java.util.List<String> roles;
}

// === ARCHIVO: src/main/java/com/ecommerce/dto/JwtRequest.java ===
package com.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para la solicitud de autenticación con usuario y contraseña")
public class JwtRequest {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Schema(description = "Nombre de usuario para autenticación", example = "usuario@ejemplo.com")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Schema(description = "Contraseña del usuario")
    private String password;
}

// === ARCHIVO: src/main/java/com/ecommerce/repository/ProductRepository.java ===
package com.ecommerce.repository;

import com.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> searchByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, 
                                    @Param("maxPrice") BigDecimal maxPrice);

    @Query("SELECT p FROM Product p WHERE p.stock < :threshold")
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);

    @Query("SELECT p FROM Product p WHERE p.stock = 0")
    List<Product> findOutOfStockProducts();

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllOrderByPriceAsc();

    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> findAllOrderByPriceDesc();

    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    Page<Product> findAvailableProducts(Pageable pageable);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.stock > 0")
    Long countAvailableProducts();

    @Query("SELECT p FROM Product p JOIN p.orders o WHERE o.id = :orderId")
    List<Product> findByOrderId(@Param("orderId") Long orderId);

    boolean existsByName(String name);

    @Query("SELECT p FROM Product p WHERE p.imageUrl IS NOT NULL AND p.imageUrl <> ''")
    List<Product> findProductsWithImages();
}

// === ARCHIVO: src/main/java/com/ecommerce/repository/OrderRepository.java ===
package com.ecommerce.repository;

import com.ecommerce.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId ORDER BY o.orderDate DESC")
    List<Order> findRecentOrdersByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(@Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> findByOrderDateBetween(@Param("startDate") LocalDateTime startDate, 
                                        @Param("endDate") LocalDateTime endDate);

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId AND o.status = :status")
    List<Order> findByCustomerIdAndStatus(@Param("customerId") Long customerId, 
                                           @Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.status = 'PENDING' ORDER BY o.orderDate ASC")
    List<Order> findPendingOrders();

    @Query("SELECT o FROM Order o WHERE o.status = 'COMPLETED' AND o.orderDate >= :since")
    List<Order> findCompletedOrdersSince(@Param("since") LocalDateTime since);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.customer.id = :customerId")
    Long countOrdersByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.customer.id = :customerId")
    java.math.BigDecimal sumTotalAmountByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT o FROM Order o JOIN o.products p WHERE p.id = :productId")
    List<Order> findByProductId(@Param("productId") Long productId);

    @Query("SELECT o.status, COUNT(o) FROM Order o GROUP BY o.status")
    List<Object[]> countOrdersByStatus();

    Optional<Order> findTopByCustomerIdOrderByOrderDateDesc(Long customerId);

    @Query("SELECT o FROM Order o WHERE o.customer.email = :email")
    List<Order> findByCustomerEmail(@Param("email") String email);
}

// === ARCHIVO: src/main/java/com/ecommerce/repository/CustomerRepository.java ===
package com.ecommerce.repository;

import com.ecommerce.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> searchByName(@Param("name") String name);

    @Query("SELECT c FROM Customer c WHERE c.city = :city")
    List<Customer> findByCity(@Param("city") String city);

    @Query("SELECT c FROM Customer c WHERE c.country = :country")
    List<Customer> findByCountry(@Param("country") String country);

    @Query("SELECT c FROM Customer c WHERE c.city = :city AND c.country = :country")
    List<Customer> findByCityAndCountry(@Param("city") String city, 
                                         @Param("country") String country);

    @Query("SELECT c FROM Customer c WHERE c.phone IS NOT NULL AND c.phone <> ''")
    List<Customer> findCustomersWithPhone();

    @Query("SELECT c FROM Customer c JOIN c.orders o WHERE o.status = 'COMPLETED' GROUP BY c HAVING COUNT(o) >= :minOrders")
    List<Customer> findFrequentCustomers(@Param("minOrders") Long minOrders);

    @Query("SELECT c FROM Customer c JOIN c.orders o GROUP BY c ORDER BY SUM(o.totalAmount) DESC")
    List<Customer> findTopCustomersBySpent();

    @Query("SELECT c FROM Customer c WHERE c.email LIKE CONCAT('%', :domain)")
    List<Customer> findByEmailDomain(@Param("domain") String domain);

    @Query("SELECT c.country, COUNT(c) FROM Customer c GROUP BY c.country")
    List<Object[]> countCustomersByCountry();

    @Query("SELECT c.state, COUNT(c) FROM Customer c WHERE c.country = :country GROUP BY c.state")
    List<Object[]> countCustomersByStateInCountry(@Param("country") String country);

    Page<Customer> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE c.addressLine2 IS NOT NULL AND c.addressLine2 <> ''")
    List<Customer> findCustomersWithSecondaryAddress();

    Optional<Customer> findByEmailAndPassword(String email, String password);

// === ARCHIVO: src/main/java/com/ecommerce/config/OpenApiConfig.java ===
package com.ecommerce.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String BEARER_FORMAT = "JWT";
    private static final String SCHEME_NAME = "Bearer Authentication";
    private static final String SCHEME_DESCRIPTION = "JWT token-based authentication";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce API")
                        .version("1.0")
                        .description("REST API para gestión de productos y pedidos en e-commerce. " +
                                "Incluye autenticación JWT, documentación automática y manejo de errores centralizado.")
                        .contact(new Contact()
                                .name("E-Commerce Team")
                                .email("support@ecommerce.com")
                                .url("https://www.ecommerce.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat(BEARER_FORMAT)
                                .description(SCHEME_DESCRIPTION)));
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/config/SecurityConfig.java ===
package com.ecommerce.config;

import com.ecommerce.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/products/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/api/orders/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/security/JwtAuthenticationFilter.java ===
package com.ecommerce.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);

        if (StringUtils.hasText(token) && jwtTokenUtil.validateToken(token)) {
            String username = jwtTokenUtil.getUsernameFromToken(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            List<SimpleGrantedAuthority> authorities = jwtTokenUtil.getRolesFromToken(token).stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .toList();

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/security/JwtTokenUtil.java ===
package com.ecommerce.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    private final SecretKey secretKey;
    private final long jwtExpirationMs;

    public JwtTokenUtil() {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.jwtExpirationMs = 86400000;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    public String generateToken(String username, Map<String, Object> additionalClaims) {
        return createToken(additionalClaims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(secretKey)
                .compact();
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public Boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/exception/GlobalExceptionHandler.java ===
package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(
            UnauthorizedException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.UNAUTHORIZED.value())
                .error("Unauthorized")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> error.getDefaultMessage() != null 
                                ? error.getDefaultMessage() 
                                : "Invalid value",
                        (existing, replacement) -> existing
                ));

        ValidationErrorResponse errorResponse = ValidationErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message("Input validation failed")
                .path(request.getDescription(false).replace("uri=", ""))
                .fieldErrors(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("An unexpected error occurred")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

        private ErrorResponse() {}

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }

        public static class ErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;

            public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public ErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }

            public ErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }

            public ErrorResponse build() {
                ErrorResponse response = new ErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                return response;
            }
        }
    }

    public static class ValidationErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
        private Map<String, String> fieldErrors;

        private ValidationErrorResponse() {}

        public static ValidationErrorResponseBuilder builder() {
            return new ValidationErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }
        public Map<String, String> getFieldErrors() { return fieldErrors; }
        public void setFieldErrors(Map<String, String> fieldErrors) { this.fieldErrors = fieldErrors; }

        public static class ValidationErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;
            private Map<String, String> fieldErrors = new HashMap<>();

            public ValidationErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public ValidationErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ValidationErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }

            public ValidationErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ValidationErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }

            public ValidationErrorResponseBuilder fieldErrors(Map<String, String> fieldErrors) {
                this.fieldErrors = fieldErrors;
                return this;
            }

            public ValidationErrorResponse build() {
                ValidationErrorResponse response = new ValidationErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                response.fieldErrors = this.fieldErrors;
                return response;
            }
        }
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/exception/ResourceNotFoundException.java ===
package com.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceName = "Resource";
        this.fieldName = "unknown";
        this.fieldValue = null;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.resourceName = "Resource";
        this.fieldName = "unknown";
        this.fieldValue = null;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/exception/UnauthorizedException.java ===
package com.ecommerce.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/controller/ProductController.java ===
package com.ecommerce.controller;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.service.ProductService;
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
@RequestMapping("/api/products")
@Tag(name = "Products", description = "API para gestión de productos del e-commerce")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Retorna una lista paginada de productos disponibles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Page.class))),
        @ApiResponse(responseCode = "400", description = "Parámetros de paginación inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @Parameter(description = "Parámetros de paginación y ordenamiento")
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<ProductDTO> products = productService.findAll(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Retorna un producto específico basado en su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<ProductDTO> getProductById(
            @Parameter(description = "ID del producto a buscar", example = "1")
            @PathVariable Long id) {
        ProductDTO product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo producto", description = "Registra un nuevo producto en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos del producto inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<ProductDTO> createProduct(
            @Parameter(description = "Datos del producto a crear")
            @Valid @RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza los datos de un producto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos del producto inválidos"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<ProductDTO> updateProduct(
            @Parameter(description = "ID del producto a actualizar", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del producto")
            @Valid @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.update(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto del sistema por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID del producto a eliminar", example = "1")
            @PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar productos por nombre", description = "Busca productos cuyo nombre contenga el texto especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Resultados de búsqueda obtenidos exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Page.class))),
        @ApiResponse(responseCode = "400", description = "Parámetros de búsqueda inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido")
    })
    public ResponseEntity<Page<ProductDTO>> searchProducts(
            @Parameter(description = "Texto a buscar en el nombre del producto", example = "laptop")
            @RequestParam String name,
            @Parameter(description = "Parámetros de paginación y ordenamiento")
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<ProductDTO> products = productService.searchByName(name, pageable);
        return ResponseEntity.ok(products);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/controller/OrderController.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/controller/AuthController.java ===
package com.ecommerce.controller;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.dto.JwtRequest;
import com.ecommerce.dto.JwtResponse;
import com.ecommerce.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Endpoints para autenticación y registro de usuarios")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Autentica un usuario y retorna un token JWT")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar usuario", description = "Registra un nuevo cliente en el sistema")
    public ResponseEntity<CustomerDTO> register(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(authService.register(customerDTO));
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/service/ProductService.java ===
package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        validateProductData(productDTO);
        
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setImageUrl(productDTO.getImageUrl());
        
        Product savedProduct = productRepository.save(product);
        return mapToDTO(savedProduct);
    }

    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        return mapToDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> getProductsPaged(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(this::mapToDTO);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsInStock() {
        return productRepository.findByStockGreaterThan(0).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        
        validateProductData(productDTO);
        
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setStock(productDTO.getStock());
        existingProduct.setImageUrl(productDTO.getImageUrl());
        
        Product updatedProduct = productRepository.save(existingProduct);
        return mapToDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    public ProductDTO updateStock(Long id, Integer newStock) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        
        product.setStock(newStock);
        Product updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);
    }

    private void validateProductData(ProductDTO productDTO) {
        if (productDTO.getName() == null || productDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es requerido");
        }
        if (productDTO.getPrice() == null || productDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (productDTO.getStock() == null || productDTO.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/service/OrderService.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/service/AuthService.java ===
package com.ecommerce.service;

import com.ecommerce.dto.JwtRequest;
import com.ecommerce.dto.JwtResponse;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public JwtResponse login(JwtRequest request) {
        throw new UnsupportedOperationException("Implementar autenticación JWT");
    }

    public JwtResponse register(JwtRequest request) {
        throw new UnsupportedOperationException("Implementar registro de usuario");
    }

    public boolean validateToken(String token) {
        throw new UnsupportedOperationException("Implementar validación de token");
    }

    public String getUsernameFromToken(String token) {
        throw new UnsupportedOperationException("Implementar extracción de usuario del token");
    }
}

// === ARCHIVO: src/main/resources/data.sql ===
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

// === ARCHIVO: Dockerfile ===
# Stage 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

// === ARCHIVO: docker-compose.yml ===
version: '3.8'

services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/ecommerce
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=postgres
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
    depends_on:
      - postgres

  postgres:
    image: postgres:16-alpine
    ports:
      - "5432:5432"
    environment:
      - POSTGRES_DB=ecommerce
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:

// === ARCHIVO: src/test/java/com/ecommerce/service/ProductServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/ecommerce/service/OrderServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/ecommerce/integration/ProductControllerIntegrationTest.java ===
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

// === ARCHIVO: src/test/java/com/ecommerce/integration/OrderControllerIntegrationTest.java ===
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
```
