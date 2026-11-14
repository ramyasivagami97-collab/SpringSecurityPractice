**Spring Security Practice**

**Project Overview**

A hands-on Spring Boot project to learn and implement authentication and authorization using Spring Security and JWT.

**Technologies Used**

* Java 23
* Spring Boot
* Spring Security
* Spring Data JPA / Hibernate
* MySQL
* JWT (JSON Web Token)
* BCrypt
* Maven

**Key Features**

* User registration with secure password hashing using BCrypt.
* User authentication using Spring Security's AuthenticationManager.
* JWT generation and validation.
* Stateless authentication using JWT.
* Role-based authorization (ADMIN and USER).
* Custom UserDetailsService for loading users from MySQL.
* Protected REST API endpoints.

**Authentication Flow**

* Users register with their details and passwords are securely hashed.
* Users log in with their email and password.
* A JWT is generated after successful authentication.
* JwtAuthenticationFilter validates the token on protected requests.
* Spring Security checks the user's role before granting access.

**Authorization Header:** 
Authorization: Bearer <your-jwt-token>

**How to Run**

* Clone the repository:
    git clone https://github.com/ramyasivagami97-collab/SpringSecurityPractice.git
* Open the project in IntelliJ IDEA.
* Create the MySQL database:
* CREATE DATABASE spring_security_practice;
* Configure these environment variables:
  * DB_USERNAME 
  * DB_PASSWORD 
  * JWT_SECRET (Base64-encoded secret key)
* Run SpringSecurityPracticeApplication.java.