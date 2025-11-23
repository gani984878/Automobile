# Automobile Knowledge Web Application

A premium full-stack web application for exploring automobiles, learning automotive history, and visualizing car data with interactive dashboards.

## 🚀 Features

### Frontend (Angular 15+)
- **Premium UI/UX** with smooth animations and transitions
- **Homepage** with hero banner, featured cars, and category highlights
- **Car Explorer** with advanced filtering (type, brand, year, price)
- **Detailed Car Pages** with comprehensive specifications
- **Knowledge Hub** featuring automotive history, evolution timeline, and pioneers
- **Interactive Dashboard** with multiple chart types (line, pie, bar, gauge)
- **Admin Panel** for CRUD operations on cars
- **Dark/Light Mode** toggle
- **Responsive Design** - mobile-first approach

### Backend (Spring Boot)
- **RESTful API** with JSON responses
- **H2 In-Memory Database** (easily switchable to MySQL)
- **CORS Enabled** for frontend integration
- **Swagger/OpenAPI** documentation
- **Seed Data** with 15+ premium cars
- **Full CRUD** operations for automobiles

## 🛠 Tech Stack

### Frontend
- Angular 15+
- TypeScript
- SCSS (with CSS variables for theming)
- Chart.js / ng2-charts for visualizations
- RxJS for reactive programming

### Backend
- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database
- Lombok
- Swagger/OpenAPI

## 📁 Project Structure

```
Cricket/
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/automobile/app/
│   │       │   ├── entity/
│   │       │   ├── repository/
│   │       │   ├── service/
│   │       │   ├── controller/
│   │       │   └── config/
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   ├── pages/
│   │   │   ├── services/
│   │   │   ├── models/
│   │   │   └── animations.ts
│   │   ├── styles.scss
│   │   └── index.html
│   ├── package.json
│   └── angular.json
└── README.md
```

## 🚦 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Node.js 16+ and npm
- Angular CLI 15+

### Backend Setup

1. Navigate to the backend directory:
```bash
cd backend
```

2. Build and run the Spring Boot application:
```bash
mvn clean install
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

3. Access Swagger UI at: `http://localhost:8080/swagger-ui.html`
4. Access H2 Console at: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:automobiledb`
   - Username: `sa`
   - Password: (leave empty)

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install --legacy-peer-deps
```

**Note:** Due to peer dependency conflicts between Angular 15 and ng2-charts, you must use `--legacy-peer-deps` flag. This is safe and the application will work correctly.

3. Start the development server:
```bash
ng serve
```

The frontend will start on `http://localhost:4200`

## 📡 API Endpoints

### Cars
- `GET /api/cars` - Get all cars
- `GET /api/cars/{id}` - Get car by ID
- `GET /api/cars/featured` - Get featured cars
- `GET /api/cars/filter` - Filter cars (query params: type, brand, startYear, endYear, minPrice, maxPrice)
- `GET /api/cars/types` - Get distinct car types
- `GET /api/cars/brands` - Get distinct brands
- `POST /api/cars` - Create new car
- `PUT /api/cars/{id}` - Update car
- `DELETE /api/cars/{id}` - Delete car

### Dashboard
- `GET /api/dashboard/stats` - Get dashboard statistics for charts

## 🎨 Key Features Explained

### Homepage
- Hero section with gradient background and animations
- Featured car of the day with detailed specs
- Category highlights (Sports Cars, Classics, SUVs, EVs, Hypercars)
- Parallax scrolling effects

### Car Explorer
- Grid layout with car cards
- Advanced filtering system
- Pagination support
- Responsive design

### Knowledge Hub
- Automotive history overview
- Interactive evolution timeline
- Famous pioneers section
- Links to dashboard for charts

### Dashboard
- Line chart: Horsepower trends over years
- Pie chart: Car types distribution
- Bar chart: Cars by year
- Gauge chart: Average performance rating
- Statistics overview cards

### Admin Panel
- Login page (demo: admin/admin)
- Full CRUD operations
- Modal form for add/edit
- Image URL support
- Comprehensive car data management


## 📝 Seed Data

The application comes pre-loaded with 15+ premium cars including:
- Hypercars (Ferrari LaFerrari, McLaren P1, Bugatti Chiron)
- Sports Cars (Porsche 911, Lamborghini Huracán, Audi R8)
- Electric Vehicles (Tesla Model S, Porsche Taycan, Rimac Nevera)
- SUVs (Lamborghini Urus, Bentley Bentayga, Aston Martin DBX)
- Classic Cars (Ford Mustang, Chevrolet Corvette, Porsche 911 RS)

## 🔧 Configuration

### Backend
Edit `backend/src/main/resources/application.properties` to:
- Change database (switch from H2 to MySQL)
- Modify server port
- Adjust CORS settings

### Frontend
Edit `frontend/src/app/services/car.service.ts` to change API URL if needed.

## 🎨 Theming

The application supports dark/light mode with CSS variables defined in `styles.scss`. Toggle theme using the button in the navbar.

## 📱 Responsive Design

The application is fully responsive and optimized for:
- Desktop (1200px+)
- Tablet (768px - 1199px)
- Mobile (< 768px)

## 🚀 Production Build

### Backend
```bash
cd backend
mvn clean package
java -jar target/automobile-api-1.0.0.jar
```

### Frontend
```bash
cd frontend
ng build --configuration production
```

Output will be in `frontend/dist/automobile-frontend/`

## 🤝 Contributing

This is a complete production-ready application. Feel free to extend it with:
- User authentication (JWT)
- Image upload functionality
- Advanced search
- Favorites/Wishlist
- Reviews and ratings
- More chart types

## 📄 License

This project is open source and available for educational purposes.

## 🙏 Acknowledgments

- Unsplash for car images
- Chart.js for visualization library
- Angular and Spring Boot communities

---

**Built with ❤️ for automobile enthusiasts**

