package com.automobile.app.repository;

import com.automobile.app.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for Car entity
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Find by type
    List<Car> findByType(String type);

    // Find by brand
    List<Car> findByBrand(String brand);

    // Find featured cars
    List<Car> findByIsFeaturedTrue();

    // Find by year range
    List<Car> findByYearBetween(Integer startYear, Integer endYear);

    // Find by price range
    List<Car> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Find by multiple filters
    List<Car> findByTypeAndYearBetweenAndPriceBetween(
            String type, Integer startYear, Integer endYear,
            BigDecimal minPrice, BigDecimal maxPrice);

    // Get distinct types
    @Query("SELECT DISTINCT c.type FROM Car c")
    List<String> findDistinctTypes();

    // Get distinct brands
    @Query("SELECT DISTINCT c.brand FROM Car c")
    List<String> findDistinctBrands();
}

