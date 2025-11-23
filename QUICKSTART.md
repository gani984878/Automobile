# Quick Start Guide

## 🚀 Quick Setup (5 minutes)

### 1. Start Backend

```bash
cd backend
mvn spring-boot:run
```

Wait for: `Started AutomobileApplication in X.XXX seconds`

### 2. Start Frontend (New Terminal)

```bash
cd frontend
npm install
ng serve
```

Wait for: `Application bundle generation complete`

### 3. Open Browser

Navigate to: `http://localhost:4200`

## ✅ Verify Setup

1. **Backend is running**: Visit `http://localhost:8080/api/cars` - should return JSON array
2. **Frontend is running**: Visit `http://localhost:4200` - should show homepage
3. **Swagger UI**: Visit `http://localhost:8080/swagger-ui.html` - should show API docs

## 🎯 Test Features

1. **Homepage**: See featured car and categories
2. **Explore**: Click "Explore Cars" to see all cars
3. **Filters**: Use filters to search by type, brand, year, price
4. **Details**: Click any car card to see full details
5. **Knowledge Hub**: Learn about automotive history
6. **Dashboard**: View interactive charts
7. **Admin**: Login with `admin/admin` to manage cars

## 🐛 Troubleshooting

### Backend won't start
- Check Java version: `java -version` (need 17+)
- Check port 8080 is free
- Try: `mvn clean install` then `mvn spring-boot:run`

### Frontend won't start
- Check Node version: `node -v` (need 16+)
- Delete `node_modules` and run `npm install` again
- Check port 4200 is free

### CORS errors
- Ensure backend is running on port 8080
- Check `application.properties` has CORS settings
- Restart backend after changes

### Charts not showing
- Check browser console for errors
- Ensure backend `/api/dashboard/stats` returns data
- Try refreshing the page

## 📝 Default Data

The app comes with 15+ pre-loaded cars including:
- Hypercars (Ferrari, McLaren, Bugatti)
- Sports Cars (Porsche, Lamborghini, Audi)
- EVs (Tesla, Porsche Taycan, Rimac)
- SUVs (Lamborghini Urus, Bentley, Aston Martin)
- Classics (Mustang, Corvette, Porsche 911)

## 🎨 Features to Try

- **Dark Mode**: Toggle in navbar (🌙/☀️)
- **Animations**: Navigate between pages
- **Filters**: Try filtering by type "Hypercar" or brand "Ferrari"
- **Charts**: Visit Dashboard to see visualizations
- **Admin**: Add/edit/delete cars in Admin Panel

Enjoy exploring! 🚗

