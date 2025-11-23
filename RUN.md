# How to Run the Application

## Prerequisites Check

Before starting, ensure you have:
- ✅ Java 17 or higher (`java -version`)
- ✅ Maven 3.6+ (`mvn -version`)
- ✅ Node.js 16+ (`node -v`)
- ✅ npm (`npm -v`)
- ✅ Angular CLI 15+ (`ng version` or install with `npm install -g @angular/cli`)

## Step-by-Step Instructions

### Step 1: Start the Backend (Spring Boot)

1. Open a terminal/command prompt
2. Navigate to the backend directory:
   ```bash
   cd backend
   ```

3. Build and run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

4. Wait for the message: `Started AutomobileApplication in X.XXX seconds`

5. The backend will be running on: **http://localhost:8080**

6. Verify it's working:
   - Open browser: http://localhost:8080/api/cars
   - You should see JSON data with cars
   - Swagger UI: http://localhost:8080/swagger-ui.html

### Step 2: Start the Frontend (Angular)

1. Open a **NEW** terminal/command prompt (keep backend running)

2. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

3. Install dependencies (first time only):
   ```bash
   npm install --legacy-peer-deps
   ```
   
   **Important:** You must use `--legacy-peer-deps` due to peer dependency conflicts. This is safe and required.

4. Start the Angular development server:
   ```bash
   ng serve
   ```
   
   Or if you don't have Angular CLI globally:
   ```bash
   npx ng serve
   ```

5. Wait for the message: `Application bundle generation complete`

6. The frontend will be running on: **http://localhost:4200**

7. Open your browser and navigate to: **http://localhost:4200**

## Quick Commands Summary

### Backend
```bash
cd backend
mvn spring-boot:run
```

### Frontend
```bash
cd frontend
npm install          # First time only
ng serve             # Or: npx ng serve
```

## What You Should See

1. **Homepage**: Beautiful hero section with featured car
2. **Navigation**: Top navbar with links to all pages
3. **Explore**: Click "Explore Cars" to see all vehicles
4. **Knowledge Hub**: Learn about automotive history
5. **Dashboard**: View interactive charts
6. **Admin**: Login with `admin/admin` to manage cars

## Troubleshooting

### Backend Issues

**Port 8080 already in use:**
```bash
# Windows: Find and kill process
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Or change port in: backend/src/main/resources/application.properties
# Change: server.port=8080 to server.port=8081
```

**Java version error:**
- Ensure Java 17+ is installed
- Check: `java -version`
- Update JAVA_HOME if needed

**Maven build fails:**
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend Issues

**Port 4200 already in use:**
```bash
# Use different port
ng serve --port 4201
```

**npm install fails:**
```bash
# Clear cache and retry
npm cache clean --force
rm -rf node_modules package-lock.json
npm install
```

**Angular CLI not found:**
```bash
# Install globally
npm install -g @angular/cli

# Or use npx
npx ng serve
```

**Module not found errors:**
```bash
# Reinstall dependencies
cd frontend
rm -rf node_modules
npm install
```

### Connection Issues

**CORS errors:**
- Ensure backend is running on port 8080
- Check `backend/src/main/resources/application.properties` has CORS settings
- Restart backend after changes

**API not responding:**
- Check backend is running: http://localhost:8080/api/cars
- Check browser console for errors
- Verify API URL in `frontend/src/app/services/car.service.ts`

## Testing the Application

1. **Homepage**: Should show featured car and categories
2. **Car Explorer**: 
   - Click "Explore Cars"
   - Try filters (type, brand, year, price)
   - Click any car card to see details
3. **Knowledge Hub**: View history and timeline
4. **Dashboard**: See charts with data
5. **Admin Panel**:
   - Go to `/admin` or click "Admin" in navbar
   - Login: username=`admin`, password=`admin`
   - Add/edit/delete cars

## Stopping the Application

- **Backend**: Press `Ctrl+C` in the backend terminal
- **Frontend**: Press `Ctrl+C` in the frontend terminal

## Next Steps

Once running:
- Explore all features
- Try dark mode toggle (🌙/☀️ in navbar)
- Add new cars via Admin Panel
- Customize the UI in `frontend/src/styles.scss`
- Modify API in backend controllers

Enjoy! 🚗

