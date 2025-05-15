# bibliotecaMaven
Public API con Java 21, Maven y Springboot 3.4.5, DDD y Api-Key, con sistema de libros y autores.

API-KEY: mi-api-key-super-secreta

Nota: Para crear libros primero tiene que crear un Autor de lo contrario tendra un estado 403.

CURLs: 

Listar Libros
curl --location 'http://localhost:8080/api/books' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87' \
--data ''

Crear Libros
curl --location 'http://localhost:8080/api/books' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87' \
--data '{"title": "Cien años de soledad", "description": "Una obra maestra del realismo mágico", "authorId": 1, "publicationDate": "1967-05-30"}'

Listar un solo Libro 
curl --location 'http://localhost:8080/api/books/2' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87'

Actualizar Libro 
curl --location --request PUT 'http://localhost:8080/api/books/2' \
--header 'Content-Type: application/json' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87' \
--data '{"title": "Cien años de soledad (Edición Especial 2)", "description": "Clásico de la literatura hispanoamericana", "authorId": 1, "publicationDate": "1967-05-30"}'

Eliminar Libro
curl --location --request DELETE 'http://localhost:8080/api/books/2' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87'

Listar Autores
curl --location 'http://localhost:8080/api/authors' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87'

Crear Autor
curl --location 'http://localhost:8080/api/authors' \
--header 'Content-Type: application/json' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87' \
--data '{"name": "Gabriel García Márquez", "nationality": "Colombiano"}'

Listar un solo Autor
curl --location 'http://localhost:8080/api/authors/1' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87'

Actualizar Autor
curl --location --request PUT 'http://localhost:8080/api/authors/1' \
--header 'Content-Type: application/json' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87' \
--data '{"name": "Gabriel García Márquez", "nationality": "Colombia"}'

Eliminar Autor
curl --location --request DELETE 'http://localhost:8080/api/authors/1' \
--header 'X-API-KEY: mi-api-key-super-secreta' \
--header 'Cookie: JSESSIONID=79FB9DA978363430C8E34D9859F9FF87'


