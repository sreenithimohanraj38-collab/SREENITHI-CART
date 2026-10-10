# Sreenithi Mart - E-Commerce Platform

An Amazon/Flipkart-style e-commerce web application with a Java Spring Boot backend and HTML/CSS frontend.

## Project Structure

```
sreenithi-mart/
├── backend/                    # Java Spring Boot Backend
│   ├── pom.xml                 # Maven configuration
│   └── src/main/
│       ├── java/com/sreenithimart/shop/
│       │   ├── SreenithiMartApplication.java    # Main class
│       │   ├── model/                          # Product, User, Order models
│       │   ├── service/                        # Business logic
│       │   └── controller/                     # REST API controllers
│       └── resources/
│           └── application.properties           # Config
├── frontend/                   # HTML/CSS Frontend
│   ├── index.html             # Main page
│   ├── login.html             # Login page
│   ├── admin.html             # Admin dashboard
│   ├── seller.html            # Seller dashboard
│   ├── buyer.html             # Buyer page
│   └── styles.css             # All styles
└── README.md                  # This file
```

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+** (or use the Maven wrapper)
- **Web browser** (Chrome, Firefox, Edge)

## How to Run

### Step 1: Start the Java Backend

```bash
cd backend
mvn spring-boot:run
```

The backend will start on **http://localhost:8080**

### Step 2: Open the Frontend

Open `frontend/index.html` in your browser, or use a local server:

```bash
cd frontend
python -m http.server 3000
# Then visit http://localhost:3000
```

## Login Credentials

| Role | Email | Password |
|------|-------|----------|
| **Admin** | `admin@sreenithimart.com` | `admin123` |
| **Seller** | `kumar@sreenithimart.com` | `seller123` |
| **Buyer** | `arun@email.com` | `buyer123` |

## API Endpoints

| Endpoint | Description |
|----------|-------------|
| `GET /api/products` | Get all products |
| `GET /api/products/{id}` | Get product by ID |
| `GET /api/search?keyword=xxx` | Search products |
| `GET /api/category/{category}` | Filter by category |
| `POST /api/auth/login` | User login |
| `GET /api/admin/dashboard` | Admin dashboard stats |
| `GET /api/admin/sellers` | All sellers |
| `GET /api/admin/buyers` | All buyers |
| `GET /api/admin/orders` | All orders |
| `GET /api/seller/dashboard` | Seller dashboard |
| `POST /api/seller/products` | Add product |
| `POST /api/buyer/orders` | Place order |
| `GET /api/buyer/orders/{buyerId}` | Buyer orders |

## Features

- Product catalog with 30+ products across 6 categories
- Search functionality
- Category filtering
- Shopping cart with add/remove/quantity controls
- Order placement with database persistence
- Admin dashboard with full details
- Seller product management
- Responsive design (mobile-friendly)
- Star ratings and discount badges
- Amazon/Flipkart-inspired dark theme UI

## Tech Stack

- **Backend**: Java 17, Spring Boot 3.2, Maven
- **Frontend**: HTML5, CSS3, Vanilla JavaScript
- **API**: RESTful JSON
