# Job Hunter API 🚀

A modern, production-ready RESTful API built with **Java 17** and **Spring Boot**, designed to track and manage tech job listings across Gauteng. This application follows enterprise 3-tier architectural standards and utilizes persistent storage powered by **PostgreSQL** and **Spring Data JPA**.

---

## 🛠️ Tech Stack & Key Technologies

* **Language:** Java 17 (JDK 17)
* **Framework:** Spring Boot 4.0.6
* **Database:** PostgreSQL
* **ORM / Persistence:** Spring Data JPA / Hibernate
* **Connection Pooling:** HikariCP
* **Build Tool:** Apache Maven
* **Architecture:** 3-Tier Layered Architecture (Controller -> Service -> Repository)

---

## 🏗️ Architecture Overview

The application is structured into three clean, decoupled layers:

1. **Presentation Layer (`@RestController`):** Handles incoming HTTP requests, maps JSON bodies, and manages HTTP response statuses.
2. **Business Layer (`@Service`):** Implements business rules, processing logic, and transaction boundaries.
3. **Data Access Layer (`@Repository`):** Leverages `JpaRepository` to perform ORM mappings and raw CRUD operations against PostgreSQL.

---

## 📋 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/jobs/search` | Retrieve all job listings |
| `POST` | `/api/jobs` | Create a new job listing |

---

## 🚀 Local Setup & Installation

### Prerequisites
* **Java 17** or higher installed
* **PostgreSQL** installed and running on port `5432`
* **Maven** (or use the included Maven wrapper)

### Database Configuration
1. Open PostgreSQL (via `pgAdmin` or `psql`) and create a database named `jobhunterdb`:
   ```sql
   CREATE DATABASE jobhunterdb;

2. Update your `src/main/resources/application.properties` file with your credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/jobhunterdb
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   spring.jpa.hibernate.ddl-auto=update

### Running the Application
Run the Spring Boot application using Maven:
   ```bash
   ./mvnw spring-boot:run
```
---

# 🧪 Testing the API
### Seed a New Job Entry (POST)

```bash
curl -X POST http://localhost:8080/api/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Junior Java Developer",
    "company": "Nexio",
    "location": "Midrand",
    "salary": 35000.00,
    "techStack": "Java 17, Spring Boot, PostgreSQL"
  }'
```

### Retrieve the listing (GET)
* Open your browser or run:
  ```bash
  curl http://localhost:8080/api/jobs/search
  ```
  
