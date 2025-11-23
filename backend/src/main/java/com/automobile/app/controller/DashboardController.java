package com.automobile.app.controller;

import com.automobile.app.entity.Car;
import com.automobile.app.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Controller for Dashboard statistics and charts data
 */
@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    private final CarRepository carRepository;

    public DashboardController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Get dashboard statistics for charts
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        List<Car> allCars = carRepository.findAll();
        
        Map<String, Object> stats = new HashMap<>();
        
        // Horsepower trends (line chart data)
        Map<Integer, Double> horsepowerTrends = allCars.stream()
                .filter(c -> c.getHorsepower() != null && c.getYear() != null)
                .collect(Collectors.groupingBy(
                        Car::getYear,
                        Collectors.averagingInt(Car::getHorsepower)
                ));
        stats.put("horsepowerTrends", horsepowerTrends);
        
        // Car types distribution (pie chart data)
        Map<String, Long> typeDistribution = allCars.stream()
                .filter(c -> c.getType() != null)
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
        stats.put("typeDistribution", typeDistribution);
        
        // Sales by year (bar chart data) - using count as proxy
        Map<Integer, Long> salesByYear = allCars.stream()
                .filter(c -> c.getYear() != null)
                .collect(Collectors.groupingBy(Car::getYear, Collectors.counting()));
        stats.put("salesByYear", salesByYear);
        
        // Average performance rating (gauge chart data)
        OptionalDouble avgPerformance = allCars.stream()
                .filter(c -> c.getPerformanceRating() != null)
                .mapToDouble(Car::getPerformanceRating)
                .average();
        stats.put("averagePerformanceRating", avgPerformance.orElse(0.0));
        
        // Additional stats
        stats.put("totalCars", allCars.size());
        stats.put("totalBrands", carRepository.findDistinctBrands().size());
        stats.put("totalTypes", carRepository.findDistinctTypes().size());
        
        return ResponseEntity.ok(stats);
    }
}

