package com.automobile.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
 * Car Entity representing automobile data
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String type; // Sports, Classic, SUV, EV, Hypercar, etc.

    @Column(name = "model_year", nullable = false)
    private Integer year;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(length = 1000)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    // Engine Specifications
    @Column(name = "engine_type")
    private String engineType; // V8, V6, Electric, etc.

    @Column(name = "horsepower")
    private Integer horsepower;

    @Column(name = "torque")
    private Integer torque; // in Nm

    @Column(name = "displacement")
    private Double displacement; // in liters

    // Performance Stats
    @Column(name = "top_speed")
    private Integer topSpeed; // in km/h

    @Column(name = "acceleration_0_100")
    private Double acceleration0To100; // in seconds

    @Column(name = "fuel_economy")
    private Double fuelEconomy; // in L/100km

    // Tech Features
    @Column(name = "tech_features", length = 2000)
    private String techFeatures; // JSON string or comma-separated

    @Column(name = "safety_rating")
    private Double safetyRating; // 0-5 stars

    @Column(name = "performance_rating")
    private Double performanceRating; // 0-10

    @Column(name = "is_featured")
    private Boolean isFeatured = false;

    @Column(name = "created_at")
    private LocalDate createdAt;

    // Constructors
    public Car() {
    }

    public Car(Long id, String name, String brand, String type, Integer year, BigDecimal price,
               String description, String imageUrl, String engineType, Integer horsepower,
               Integer torque, Double displacement, Integer topSpeed, Double acceleration0To100,
               Double fuelEconomy, String techFeatures, Double safetyRating,
               Double performanceRating, Boolean isFeatured, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.engineType = engineType;
        this.horsepower = horsepower;
        this.torque = torque;
        this.displacement = displacement;
        this.topSpeed = topSpeed;
        this.acceleration0To100 = acceleration0To100;
        this.fuelEconomy = fuelEconomy;
        this.techFeatures = techFeatures;
        this.safetyRating = safetyRating;
        this.performanceRating = performanceRating;
        this.isFeatured = isFeatured;
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public Integer getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(Integer topSpeed) {
        this.topSpeed = topSpeed;
    }

    public Double getAcceleration0To100() {
        return acceleration0To100;
    }

    public void setAcceleration0To100(Double acceleration0To100) {
        this.acceleration0To100 = acceleration0To100;
    }

    public Double getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(Double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public String getTechFeatures() {
        return techFeatures;
    }

    public void setTechFeatures(String techFeatures) {
        this.techFeatures = techFeatures;
    }

    public Double getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(Double safetyRating) {
        this.safetyRating = safetyRating;
    }

    public Double getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(Double performanceRating) {
        this.performanceRating = performanceRating;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
