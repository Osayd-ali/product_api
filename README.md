Product API
A RESTful API built with Spring Boot for managing product inventory with comprehensive error handling and validation.
Overview
This project implements a complete product management system with CRUD operations, custom validation, and proper exception handling. It demonstrates key Spring Boot concepts including dependency injection, REST controllers, service layers, and configuration management.
Features

Complete CRUD Operations: Create, read, update, and delete products
Custom Validation: Enforces business rules for product data integrity
Exception Handling: Centralized error handling with meaningful HTTP responses
Filtered Queries: Built-in support for filtering test products via configuration
RESTful Design: Follows REST API best practices

Technologies Used

Java 21
Spring Boot 3.2.8
Maven
Spring Web

Project Structure
src/main/java/
├── controllers/       # REST endpoints
├── services/          # Business logic layer
├── dataholder/        # In-memory data storage
├── entities/          # Domain models
└── exceptions/        # Custom exceptions

src/main/resources/
└── application.properties

API Endpoints

Base URL: /api/products

Product Validation Rules

Product ID: Must be exactly 6 characters long and cannot be null
Product Name: Cannot be null or empty
Product Cost: Must be greater than zero

Violations throw InvalidProductException with descriptive error messages.

Configuration
The application uses application.properties for configuration:
product.test.prefix=AAA
Products with IDs starting with this prefix are automatically filtered from GET requests.

Running the Application

Clone the repository
Navigate to the project directory
Run using Maven:
The API will be available at http://localhost:8080

Testing
Use Postman or any HTTP client to test the endpoints. The application includes:

Custom exception handling for validation errors
HTTP status codes (200, 400, 404) for different scenarios
Structured error responses for debugging

Key Design Patterns

Layered Architecture: Separation of concerns with controller, service, and data layers
Dependency Injection: Constructor-based injection for loose coupling
Repository Pattern: ProductData acts as an in-memory repository
Exception Handling: Centralized error handling with @ExceptionHandler

Future Enhancements

Database integration (JPA/Hibernate)
Authentication and authorization
Pagination for large product lists
Search and filtering capabilities
API documentation with Swagger/OpenAPI
