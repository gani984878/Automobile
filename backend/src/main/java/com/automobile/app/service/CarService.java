package com.automobile.app.service;

import com.automobile.app.entity.Car;
import com.automobile.app.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service layer for Car operations
 */
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Get all cars
     */
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    /**
     * Get car by ID
     */
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    /**
     * Create a new car
     */
    @Transactional
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    /**
     * Update an existing car
     */
    @Transactional
    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        
        car.setName(carDetails.getName());
        car.setBrand(carDetails.getBrand());
        car.setType(carDetails.getType());
        car.setYear(carDetails.getYear());
        car.setPrice(carDetails.getPrice());
        car.setDescription(carDetails.getDescription());
        car.setImageUrl(carDetails.getImageUrl());
        car.setEngineType(carDetails.getEngineType());
        car.setHorsepower(carDetails.getHorsepower());
        car.setTorque(carDetails.getTorque());
        car.setDisplacement(carDetails.getDisplacement());
        car.setTopSpeed(carDetails.getTopSpeed());
        car.setAcceleration0To100(carDetails.getAcceleration0To100());
        car.setFuelEconomy(carDetails.getFuelEconomy());
        car.setTechFeatures(carDetails.getTechFeatures());
        car.setSafetyRating(carDetails.getSafetyRating());
        car.setPerformanceRating(carDetails.getPerformanceRating());
        car.setIsFeatured(carDetails.getIsFeatured());
        
        return carRepository.save(car);
    }

    /**
     * Delete a car
     */
    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    /**
     * Get featured cars
     */
    public List<Car> getFeaturedCars() {
        return carRepository.findByIsFeaturedTrue();
    }

    /**
     * Filter cars by multiple criteria
     */
    public List<Car> filterCars(String type, Integer startYear, Integer endYear,
                                BigDecimal minPrice, BigDecimal maxPrice, String brand) {
        if (type != null && startYear != null && endYear != null && 
            minPrice != null && maxPrice != null) {
            return carRepository.findByTypeAndYearBetweenAndPriceBetween(
                    type, startYear, endYear, minPrice, maxPrice);
        }
        
        if (type != null) {
            return carRepository.findByType(type);
        }
        
        if (brand != null) {
            return carRepository.findByBrand(brand);
        }
        
        if (startYear != null && endYear != null) {
            return carRepository.findByYearBetween(startYear, endYear);
        }
        
        if (minPrice != null && maxPrice != null) {
            return carRepository.findByPriceBetween(minPrice, maxPrice);
        }
        
        return carRepository.findAll();
    }

    /**
     * Get distinct types
     */
    public List<String> getDistinctTypes() {
        return carRepository.findDistinctTypes();
    }

    /**
     * Get distinct brands
     */
    public List<String> getDistinctBrands() {
        return carRepository.findDistinctBrands();
    }
}

