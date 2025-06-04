# 📝 JournalApp

**JournalApp** is a backend-only REST API built with **Java** and **Spring Boot** for managing journal entries. It supports user registration (admin and normal users), secure JWT-based login, and full CRUD operations on journal entries. The project follows clean architecture and includes caching, cloud storage, code quality analysis, and unit testing.

---

## 🚀 Features

- ✅ JWT-based Authentication & Authorization
- 🔐 Role-based Access (Admin/User)
- 🗂️ Add, Update, Delete, View Journal Entries
- 👥 User Registration & Login
- ☁️ MongoDB Atlas for Cloud Database Storage
- ⚡ Redis Cloud for Caching
- 🧪 JUnit + Mockito for Testing
- 📊 SonarQube (via cloud) for Code Quality & Maintainability
- 🧼 Layered Architecture (Controllers → Services → Repositories)

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- MongoDB Atlas (Cloud NoSQL DB)
- Redis Cloud
- JUnit 5 & Mockito
- SonarQube (Cloud version)
- Postman (for API testing)

---

## 📁 Project Structure

```

com.uk.JournalApp
├── controller       // REST controllers
├── service          // Business logic
├── repository       // MongoDB database operations
├── entity/model     // Data models like User and JournalEntry
├── config           // JWT, Redis, and Spring Security configs
├── util             // Helper classes for JWT and security
└── test             // JUnit & Mockito test cases

````

---

## 📂 API Endpoints Overview

| Method | Endpoint                    | Description                      |
|--------|-----------------------------|----------------------------------|
| POST   | `/register`                 | Register a new user              |
| POST   | `/login`                    | Authenticate and receive a token|
| GET    | `/journal/all`              | Get all journal entries (Admin) |
| POST   | `/journal/add`              | Add a journal entry              |
| PUT    | `/journal/update/{id}`      | Update a journal entry           |
| DELETE | `/journal/delete/{id}`      | Delete a journal entry           |

> **Note**: All protected endpoints require a valid JWT token in the header as:  
> `Authorization: Bearer <your_token>`

---

## 🔐 Authentication

- JWT tokens are generated on login
- Required for accessing secured endpoints
- Role-based access control via Spring Security

---

## ⚙️ Configuration

Set your credentials in `application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: <your-mongodb-atlas-uri>
  redis:
    host: <your-redis-host>
    port: <your-redis-port>
    username: default
    password: <your-redis-password>
    ssl: true

jwt:
  secret: <your-jwt-secret-key>
````

---

## 🧪 Testing

* ✅ All endpoints tested using **Postman**
* ✅ Backend unit & service tests written using:

  * **JUnit 5**
  * **Mockito**

Run tests:

```bash
./mvnw test
```

---

## 📬 Postman Collection

You can use this public Postman collection to test the API:

👉 [Postman Collection Link](https://urmitkotadiya.postman.co/workspace/Urmit-Kotadiya's-Workspace~80099915-8823-4e42-8a1d-b2286c47f702/collection/43458783-209d3bb0-bd0e-4bd3-aa9c-0644d0075eba?action=share&creator=43458783)

---

## ☁️ Cloud Services Used

* **MongoDB Atlas** – Cloud-hosted NoSQL database
* **Redis Cloud** – For temporary in-memory storage & caching
* **SonarQube Cloud** – For code quality tracking

---

## 🚀 Getting Started

1. **Clone the repo**:

   ```bash
   git clone https://github.com/uk1011/JournalApp.git
   cd JournalApp
   ```

2. **Set up `application.yml`** with MongoDB, Redis, and JWT details.

3. **Run the app**:

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test endpoints** using the shared Postman collection.

---

## 🙋‍♂️ Author

Made with ❤️ by [@uk1011](https://github.com/uk1011)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

