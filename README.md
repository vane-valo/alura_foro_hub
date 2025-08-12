# API REST para un Foro (Challenge Alura)

## Descripción del Proyecto:
Esta API REST proporciona una plataforma para la creación y gestión de tópicos en un foro. Permite a los usuarios crear, leer, actualizar y eliminar tópicos, así como autenticarse mediante JWT.

## Funcionalidades:

Listar todos los tópicos.
Crear un nuevo tópico.
Actualizar un tópico existente.
Eliminar un tópico existente.
Autenticación de usuarios mediante JWT.

## Herramientas y Dependencias:

Java
SpringBoot
Base de datos (ej. MySQL, PostgreSQL, H2)
Insomnia (o similar) para pruebas de la API
JWT para autenticación

## Configuración:

Asegúrate de tener instalado Java y Maven.
Configura la conexión a la base de datos en application.properties.
Aplica las migraciones de la base de datos (si es necesario).

## Cómo Ejecutar el Proyecto:

Clona el repositorio.

Ejecuta mvn spring-boot:run desde la línea de comandos.
La API estará disponible en http://localhost:8080.

## Endpoints de la API:

GET /topicos: Lista todos los tópicos. 

POST /topicos: Crea un nuevo tópico (requiere autenticación JWT).

PUT /topicos/{id}: Actualiza un tópico existente en la base de datos (requiere autenticación JWT).

DELETE /topicos/{id}: Elimina un tópico (requiere autenticación JWT).

POST /auth: Autentica un usuario y devuelve un token JWT.

## Ejemplos de Uso:

Listar tópicos:

GET http://localhost:8080/topicos

Crear un tópico (con JWT):

POST http://localhost:8080/topicos

Headers:

Authorization: Bearer <JWT_TOKEN>

Body:

{
"usuarioId": 1,

"titulo": "Nueva duda",

"mensaje": "Tengo una pregunta sobre...",

"curso": "SpringBoot"

}
