# 🔐 JWT User Management API

A secure REST API built using **Spring Boot 3**, **Spring Security**, **JWT (JSON Web Token)**, **MySQL**, and **Spring Data JPA**. This project demonstrates user authentication, authorization, password encryption using BCrypt, and role-based access control.

---

## 🚀 Features

- ✅ User Registration
- ✅ User Login
- ✅ JWT Token Generation
- ✅ JWT Authentication
- ✅ BCrypt Password Encryption
- ✅ Role-Based Authorization (ROLE_USER & ROLE_ADMIN)
- ✅ Protected REST APIs
- ✅ MySQL Database Integration
- ✅ Spring Security Configuration

---

## 🛠️ Tech Stack

- Java 25
- Spring Boot 3.5.16
- Spring Security
- JWT (JJWT 0.11.5)
- Spring Data JPA
- MySQL
- Maven
- Postman

---

## 📁 Project Structure

```
src
└── main
    ├── java
    │   └── com.shubham.springbootjwtauthentication
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── repository
    │       ├── security
    │       └── service
    └── resources
        └── application.properties
```

---

## 🔗 API Endpoints

### Register User

**POST** `/auth/register`

Request

```json
{
  "name": "Shubham",
  "email": "shubham@gmail.com",
  "password": "123456"
}
```

Response

```text
User Registered Successfully
```

---

### Login User

**POST** `/auth/login`

Request

```json
{
  "email": "shubham@gmail.com",
  "password": "123456"
}
```

Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

### User API (Protected)

**GET** `/api/user/profile`

Header

```
Authorization: Bearer <JWT_TOKEN>
```

Response

```text
Welcome User
```

---

### Admin API (Protected)

**GET** `/api/admin/dashboard`

Header

```
Authorization: Bearer <JWT_TOKEN>
```

Response (ROLE_ADMIN)

```text
Welcome Admin
```

---

## 🔐 Authentication Flow

```
User Registration
        │
        ▼
Password Encrypted (BCrypt)
        │
        ▼
Stored in MySQL Database
        │
        ▼
User Login
        │
        ▼
JWT Token Generated
        │
        ▼
Bearer Token
        │
        ▼
Protected APIs
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/sharmashubhamm/jwt-user-management-api.git
```

### Go to Project

```bash
cd jwt-user-management-api
```

### Configure MySQL

Create a database:

```sql
CREATE DATABASE jwt_auth_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_auth_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### Run the Project

```bash
mvn spring-boot:run
```

---

## 🧪 Testing

The APIs were tested using **Postman**.

- User Registration
- User Login
- JWT Token Generation
- Protected User Endpoint
- Protected Admin Endpoint

---

## 📌 Future Improvements

- Refresh Token
- Swagger/OpenAPI Documentation
- Global Exception Handling
- Docker Support
- Unit Testing
- Email Verification

---

## 👨‍💻 Author

**Shubham Sharma**

GitHub:
https://github.com/sharmashubhamm

---

⭐ If you found this project useful, consider giving it a star.
