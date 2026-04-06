# CampusEase 🎓

A full-stack campus application for Sharda University that allows students and faculty to pre-order food, browse campus shops, find classrooms, and navigate the campus — all from one platform.

---

## 🚀 Project Overview

CampusEase solves a common campus problem — students waste time standing in queues at canteens, missing classes just to get food or printouts. With CampusEase, students can:

-  Browse restaurants, stationary and printout shops
-  Pre-order food from their classroom
-  Pay online and pick up when ready
-  Navigate the campus
-  Find classrooms and check availability

---

## 🛠️ Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Security** (JWT Authentication)
- **Spring Data JPA** (Hibernate)
- **PostgreSQL** (Database)
- **Maven** (Build Tool)

### Frontend (Coming Soon)
- **React.js**
- **Tailwind CSS**

---

## 📁 Project Structure

```
src/main/java/com/example/CampusEase/
│
├── config/
│   ├── JwtUtil.java          # Generates & validates JWT tokens
│   ├── JwtFilter.java        # Reads & validates token on every request
│   └── SecurityConfig.java   # Security rules & filter chain
│
├── controller/
│   ├── AuthController.java       # /auth/register, /auth/login
│   ├── PlaceController.java      # /places CRUD
│   ├── ShopController.java       # /shops CRUD
│   └── MenuItemController.java   # /shops/{id}/menu CRUD
│
├── model/
│   ├── Place.java      # Campus places entity
│   ├── User.java       # User entity
│   ├── Shop.java       # Shop entity
│   └── MenuItem.java   # Menu items entity
│
├── repository/
│   ├── PlaceRepository.java
│   ├── UserRepository.java
│   ├── ShopRepository.java
│   └── MenuItemRepository.java
│
├── service/
│   ├── PlaceService.java
│   ├── UserService.java
│   ├── ShopService.java
│   └── MenuItemService.java
│
└── CampusEaseApplication.java
```

---

## 🗄️ Database Tables

| Table | Description |
|---|---|
| `users` | Stores registered users with encrypted passwords |
| `place` | Campus locations and places |
| `shops` | Canteen, stationary, printout shops |
| `menu_items` | Items inside each shop with prices |

---

## 🔐 Security

- Passwords encrypted using **BCrypt**
- Authentication via **JWT (JSON Web Token)**
- Token expiry: **10 hours**
- Protected endpoints require `Authorization: Bearer <token>` header

---

## 📡 API Endpoints

### Auth
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| POST | `/auth/register` | Register new user | 
| POST | `/auth/login` | Login & get JWT token | 

### Places
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/places` | Get all places | 
| GET | `/places/{id}` | Get one place | 
| POST | `/places` | Add new place | 
| PUT | `/places/{id}` | Update place | 
| DELETE | `/places/{id}` | Delete place | 

### Shops
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/shops` | Get all shops | 
| GET | `/shops/{id}` | Get one shop | 
| GET | `/shops/category/{category}` | Get shops by category | 
| POST | `/shops` | Add new shop | 
| PUT | `/shops/{id}` | Update shop | 
| DELETE | `/shops/{id}` | Delete shop | 

### Menu Items
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/shops/{shopId}/menu` | Get menu of a shop | 
| POST | `/shops/{shopId}/menu` | Add item to menu | 
| PUT | `/shops/{shopId}/menu/{id}` | Update menu item | 
| DELETE | `/shops/{shopId}/menu/{id}` | Delete menu item | 

---

## ⚙️ Setup & Installation

### Prerequisites
- Java 17
- Maven
- PostgreSQL
- Postman (for testing)

### Steps

**1. Clone the repository:**
```bash
git clone https://github.com/raginisingh-del/CampusEase.git
cd CampusEase
```

**2. Create PostgreSQL database:**
```sql
CREATE DATABASE campease;
```

**3. Update `application.properties`:**
```properties
spring.application.name=CampusEase
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/campease
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

**4. Run the application:**
```bash
./mvnw spring-boot:run
```

**5. Test the APIs:**
```
Base URL: http://localhost:8080
```

---

## 🧪 Testing with Postman

**Step 1 — Register:**
```json
POST /auth/register
{
    "username": "ragini",
    "password": "1234",
    "role": "STUDENT"
}
```

**Step 2 — Login:**
```json
POST /auth/login
{
    "username": "ragini",
    "password": "1234"
}
```

**Step 3 — Use token:**
```
Headers:
Authorization: Bearer <your_token_here>
```

---

## 👥 User Roles

| Role | Description |
|---|---|
| `SUPER_ADMIN` | Full access — manages everything |
| `SHOP_OWNER` | Manages their own shop and menu |
| `STUDENT` | Browse shops, place orders |
| `FACULTY` | Browse shops, place orders |

---

## 🔮 Coming Soon

- [ ] Order & OrderItem management
- [ ] Payment gateway (Razorpay)
- [ ] Classroom finder
- [ ] Real-time order notifications (WebSocket)
- [ ] QR code for order pickup
- [ ] Rating & review system
- [ ] Admin dashboard with analytics
- [ ] React.js frontend
- [ ] Campus map navigation
- [ ] Mobile app

---

## 👩‍💻 Team

| Name | Role |
|Srinath | UI Design & Frontend|
| Ragini Singh | Backend Development |
| Vikash Kumar Mishra | Map Navigation & Authentication |

---


