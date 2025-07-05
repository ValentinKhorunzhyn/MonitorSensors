🛠️ Monitor Sensors — Sensor Monitoring System
A CRUD application for managing and monitoring sensors. Built using Java (11–21), Spring Boot, Hibernate, and Spring Security.

🧩 Overview
This is a backend system that allows users to manage sensor data with full CRUD functionality. The application supports role-based access control, database persistence, and optional Docker deployment. An advanced module includes integration with a statistics service that collects and stores daily sensor reports.

📦 Features
✅ CRUD Operations for managing sensors.
🔐 Role-Based Access Control :
Administrator: Full access (create, read, update, delete).
Viewer: Read-only access.
🔍 Search Functionality : by name and model with partial match support.
🗂️ Predefined Sensor Types & Units from the database.
📘 Validation Rules on all fields.
🧪 Optional:
Swagger API documentation
Database migrations (Flyway / Liquibase)
Docker support
Statistics Service (daily reports)

👤 Users & Roles
admin -> Administrator -> Create, Read, Update, Delete
user -> Viewer -> Read-only

Authentication and authorization are handled via Spring Security .

📁 Optional Features
✅ Swagger API Documentation
Integrated using Springdoc OpenAPI UI (/swagger-ui.html or /v3/api-docs).

✅ Database Migrations
Support for Flyway or Liquibase to version-control database schema changes.

✅ Docker Support
Application can be containerized using Docker. See docker-compose.yml for multi-container setup.

🔁 Advanced Feature: Statistics Service
A separate microservice that:

Fetches sensor data every day at 02:00 AM.
Stores statistics in a dedicated database:
Total number of sensors.
Count per type.
Allows querying statistics for a given date range (e.g., from 2023-12-01 to 2023-12-10).

📦 How to Run
Local Setup
./mvnw spring-boot:run
Default port: 8080

With Docker
docker-compose up --build

Access services at:

http://localhost:8080 – Main Application
http://localhost:8081/swagger-ui.html – Swagger Docs (if enabled)
http://localhost:8081 – Statistics Service (if implemented)
