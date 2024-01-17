# Doctor-And-Patient Management System

This project is a backend application for a Doctor-And-Patient management system. It allows doctors to register, manage their specialties, and patients to register with their symptoms.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Swagger](#swagger)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- Add and remove doctors with their specialties.
- Add and remove patients with their symptoms.
- Suggest doctors based on patient symptoms and location.
- Validation for doctor and patient details.
- ...

## Prerequisites

Make sure you have the following installed:

- [Java JDK Version 20](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Spring Boot Version 3.2.1](https://spring.io/projects/spring-boot)
- [Apache Maven Version 10](https://maven.apache.org/)
- [Database (e.g., MySQL Version 8)](https://www.mysql.com/)

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/Pandey-account/doctor-and-patient.git
    cd doctor-patient-management
    ```

2. Configure the database settings in `application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. Build and run the application:

    ```bash
    mvn spring-boot:run
    ```

## API Documentation

API documentation is available using Swagger. Once the application is running, you can access Swagger UI at:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui/index.html#)

## Swagger

Swagger is integrated into the project to provide a clear and interactive API documentation. The Swagger UI allows you to explore and test the available APIs.

### Controller Descriptions

You can add descriptions to your controllers using Swagger annotations. For example, consider the following:

```java
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    // Your controller methods here
}

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    // Your controller methods here
}


