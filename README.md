# Desarrollo de una API REST para Gestión de Productos y Pedidos

El sistema gestiona productos y pedidos en un e-commerce. Debe soportar arquitectura en capas, modelado de datos con relaciones OneToMany y ManyToMany, autenticación y autorización basada en JWT, documentación automática con OpenAPI, manejo centralizado de errores, validación de entradas, paginación y ordenamiento de resultados, y pruebas unitarias e de integración. El desarrollador debe implementar el módulo completo, aplicando principios SOLID y clean code.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | arquitectura-de-api-rest-en-e-commerce |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 20 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del Modelo de Datos

**Objetivo:** Establecer el modelo de datos para productos, pedidos y clientes, incluyendo relaciones entre entidades.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Identificar las entidades y sus relaciones en el dominio del e-commerce.
- Definir las propiedades de cada entidad y las restricciones de validación.
- Establecer las relaciones OneToMany y ManyToMany entre las entidades.

**Entregable:** Modelo de datos completo con entidades y relaciones definidas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los atributos necesarios para cada entidad y cómo se relacionan en el contexto del e-commerce.
- Piensa en las restricciones de validación que deben aplicarse a cada propiedad.

</details>

### Fase 2: Implementación de la Arquitectura en Capas

**Objetivo:** Implementar la arquitectura en capas con controladores REST, servicios de negocio y repositorios JPA.

**Tiempo estimado:** 6 horas

**Instrucciones:**

- Diseñar los controladores REST para manejar las solicitudes de productos y pedidos.
- Implementar los servicios de negocio que encapsulan la lógica de la aplicación.
- Crear los repositorios JPA para persistir las entidades en la base de datos.

**Entregable:** Arquitectura en capas implementada con controladores, servicios y repositorios funcionales.

<details>
<summary>Pistas de conocimiento</summary>

- Reflexiona sobre cómo separar las responsabilidades entre las capas para mantener el código limpio y mantenible.
- Considera los métodos que cada capa debe exponer para interactuar con las demás.

</details>

### Fase 3: Autenticación y Autorización

**Objetivo:** Implementar la autenticación y autorización basada en JWT con Spring Security.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Configurar Spring Security para autenticar usuarios con JWT.
- Definir roles de ADMIN y USER y restringir el acceso a los endpoints según el rol.
- Asegurar que los endpoints sean accesibles solo para usuarios autenticados y autorizados.

**Entregable:** Sistema de autenticación y autorización funcional con JWT y Spring Security.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga los diferentes métodos de autenticación y autorización disponibles en Spring Security.
- Considera los posibles riesgos de seguridad y cómo mitigarlos en tu implementación.

</details>

### Fase 4: Documentación y Manejo de Errores

**Objetivo:** Documentar la API con OpenAPI y manejar los errores de forma centralizada.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Generar documentación automática de la API con OpenAPI 3.0 y Swagger UI.
- Implementar un manejo centralizado de errores con @ControllerAdvice y respuestas estandarizadas en formato JSON.
- Asegurar que la documentación sea accesible en /api-docs y que los errores sean manejados de forma consistente.

**Entregable:** Documentación completa de la API y manejo centralizado de errores funcional.

<details>
<summary>Pistas de conocimiento</summary>

- Explora las mejores prácticas para documentar una API REST con OpenAPI.
- Reflexiona sobre los diferentes tipos de errores que pueden ocurrir y cómo manejarlos de forma consistente.

</details>

### Fase 5: Validación de Entradas y Paginación

**Objetivo:** Implementar la validación de entradas y la paginación y ordenamiento de resultados.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Aplicar validación de entradas con Bean Validation usando @Valid, @NotNull y @Size.
- Implementar paginación y ordenamiento de resultados en los endpoints de listado usando Pageable.
- Asegurar que las entradas sean validadas correctamente y que los resultados sean paginados y ordenados según las solicitudes.

**Entregable:** Validación de entradas funcional y paginación y ordenamiento de resultados implementados.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga las diferentes anotaciones de validación disponibles en Bean Validation.
- Reflexiona sobre cómo implementar la paginación y el ordenamiento de forma eficiente y escalable.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es el modelo de datos y por qué es importante en un e-commerce?
- **paraQueSirve**: ¿Para qué sirve la autenticación y autorización en nuestra API y cómo la implementamos?
- **comoSeUsa**: ¿Cómo se usa la documentación de la API y el manejo de errores en nuestro sistema?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir durante la validación de entradas y cómo los manejamos?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de la autenticación y autorización en nuestra API?

## Criterios de Evaluacion

- Modelo de datos completo con entidades y relaciones definidas.
- Arquitectura en capas implementada con controladores, servicios y repositorios funcionales.
- Sistema de autenticación y autorización funcional con JWT y Spring Security.
- Documentación completa de la API y manejo centralizado de errores funcional.
- Validación de entradas funcional y paginación y ordenamiento de resultados implementados.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
