# 📝 Mind on Paper

Mind on Paper is a simple blogging website built using Spring Boot.
It demonstrates clean architecture with, REST API design, security configuration, and different types of testing mainly Junit and Integration testing.

## Features

- Blog Management APIs: Create, Read, Update, Delete blogs.

## Persistence with JPA:

- MySQL for production.

- H2 in-memory database for testing.

## Security:

- No Authentication for testing
  
- Basic Authentication (roles: USER, ADMIN).

- OAuth 2.0 login with Google.

## AOP (Aspect-Oriented Programming): 

- Logging
  
- Global Exception handler

## Testing:

- Unit tests with JUnit + Mockito.

- Integration tests with MockMvc and H2 database.

## API Documentation: 

- Swagger UI available.

## Tech Stack

- Backend: Spring Boot (3.x)

## Database:

- MySQL (Production)

- H2 (Testing)

## Security: 

- Spring Security
  
- Basic Auth for development
  
- OAuth2 (Google) for production

## Testing: 

- JUnit 5 for testing the service
  
- Mockito for testing the service
  
- MockMvc for testing the controller

## Build Tool: 

- Maven
