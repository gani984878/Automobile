package com.automobile.app.config;

import com.automobile.app.entity.Car;
import com.automobile.app.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Data seeder to populate initial car data
 */
@Component
public class DataSeeder implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataSeeder(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {
        if (carRepository.count() == 0) {
            seedCars();
        }
    }

    private void seedCars() {
        List<Car> cars = Arrays.asList(
            // Hypercars
            createCar("Ferrari LaFerrari", "Ferrari", "Hypercar", 2013, 
                    new BigDecimal("1400000"), 
                    "A limited production hybrid sports car with Formula 1 technology.",
                    "https://images.unsplash.com/photo-1617531653332-bd46c24f2068?w=800",
                    "V12 Hybrid", 963, 900, 6.3, 350, 2.4, 15.0,
                    "KERS, Active Aerodynamics, Carbon Fiber Monocoque", 5.0, 9.8, true),
            
            createCar("McLaren P1", "McLaren", "Hypercar", 2013,
                    new BigDecimal("1150000"),
                    "A British limited-production hybrid sports car.",
                    "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=800",
                    "V8 Twin-Turbo Hybrid", 916, 900, 3.8, 350, 2.8, 8.3,
                    "IPAS, DRS, Active Aero, Carbon Fiber", 5.0, 9.7, true),
            
            createCar("Bugatti Chiron", "Bugatti", "Hypercar", 2016,
                    new BigDecimal("3000000"),
                    "The ultimate expression of automotive engineering and luxury.",
                    "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=800",
                    "W16 Quad-Turbo", 1500, 1600, 8.0, 420, 2.5, 22.5,
                    "7-Speed DSG, All-Wheel Drive, Active Aero", 5.0, 10.0, true),

            // Sports Cars
            createCar("Porsche 911 Turbo S", "Porsche", "Sports Car", 2023,
                    new BigDecimal("215000"),
                    "The pinnacle of Porsche performance with all-wheel drive.",
                    "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=800",
                    "Flat-6 Twin-Turbo", 650, 800, 3.8, 330, 2.7, 11.1,
                    "PDK, PASM, Sport Chrono, Carbon Ceramic Brakes", 5.0, 9.5, false),
            
            createCar("Lamborghini Huracán EVO", "Lamborghini", "Sports Car", 2023,
                    new BigDecimal("261000"),
                    "A perfect blend of performance and everyday usability.",
                    "https://images.unsplash.com/photo-1544636331-e26879cd4d9b?w=800",
                    "V10", 640, 600, 5.2, 325, 2.9, 13.7,
                    "LDVI, ALA, Magnetic Suspension", 5.0, 9.4, false),
            
            createCar("Audi R8 V10 Plus", "Audi", "Sports Car", 2023,
                    new BigDecimal("199000"),
                    "German engineering meets Italian passion.",
                    "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=800",
                    "V10", 620, 580, 5.2, 331, 3.2, 13.2,
                    "Quattro AWD, Magnetic Ride, Carbon Fiber", 5.0, 9.2, false),

            // EVs
            createCar("Tesla Model S Plaid", "Tesla", "EV", 2023,
                    new BigDecimal("108000"),
                    "The fastest production sedan in the world.",
                    "https://images.unsplash.com/photo-1560958089-b8a1929cea89?w=800",
                    "Electric (3 Motors)", 1020, 1420, 0.0, 322, 2.1, 0.0,
                    "Autopilot, Over-the-Air Updates, 4680 Cells", 5.0, 9.6, true),
            
            createCar("Porsche Taycan Turbo S", "Porsche", "EV", 2023,
                    new BigDecimal("185000"),
                    "Porsche's first all-electric sports car.",
                    "https://images.unsplash.com/photo-1617531653332-bd46c24f2068?w=800",
                    "Electric (2 Motors)", 750, 1050, 0.0, 260, 2.8, 0.0,
                    "800V Architecture, 2-Speed Transmission", 5.0, 9.3, false),
            
            createCar("Rimac Nevera", "Rimac", "EV", 2023,
                    new BigDecimal("2400000"),
                    "The world's fastest electric hypercar.",
                    "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=800",
                    "Electric (4 Motors)", 1914, 2360, 0.0, 412, 1.85, 0.0,
                    "Torque Vectoring, 120kWh Battery, AI Driver Coach", 5.0, 9.9, true),

            // SUVs
            createCar("Lamborghini Urus", "Lamborghini", "SUV", 2023,
                    new BigDecimal("218000"),
                    "The world's first Super Sport Utility Vehicle.",
                    "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=800",
                    "V8 Twin-Turbo", 650, 850, 4.0, 305, 3.6, 12.7,
                    "ANIMA, ALA, Air Suspension", 5.0, 8.8, false),
            
            createCar("Bentley Bentayga Speed", "Bentley", "SUV", 2023,
                    new BigDecimal("245000"),
                    "The fastest and most powerful luxury SUV.",
                    "https://images.unsplash.com/photo-1544636331-e26879cd4d9b?w=800",
                    "W12 Twin-Turbo", 626, 900, 6.0, 306, 3.9, 18.0,
                    "48V Active Anti-Roll, All-Wheel Steering", 5.0, 8.5, false),
            
            createCar("Aston Martin DBX", "Aston Martin", "SUV", 2023,
                    new BigDecimal("189000"),
                    "The first SUV from the British luxury brand.",
                    "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=800",
                    "V8 Twin-Turbo", 550, 700, 4.0, 291, 4.5, 14.2,
                    "Active AWD, Air Suspension, GT Mode", 5.0, 8.3, false),

            // Classics
            createCar("Ford Mustang GT 1967", "Ford", "Classic", 1967,
                    new BigDecimal("45000"),
                    "The iconic American muscle car that started it all.",
                    "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=800",
                    "V8", 320, 427, 4.7, 225, 6.5, 18.0,
                    "4-Speed Manual, Front Disc Brakes", 3.0, 7.5, false),
            
            createCar("Chevrolet Corvette Stingray 1963", "Chevrolet", "Classic", 1963,
                    new BigDecimal("65000"),
                    "The split-window coupe that defined an era.",
                    "https://images.unsplash.com/photo-1544636331-e26879cd4d9b?w=800",
                    "V8", 360, 352, 5.4, 250, 5.4, 15.0,
                    "4-Speed Manual, Independent Rear Suspension", 3.5, 8.0, false),
            
            createCar("Porsche 911 2.7 RS 1973", "Porsche", "Classic", 1973,
                    new BigDecimal("500000"),
                    "The legendary lightweight racer for the road.",
                    "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=800",
                    "Flat-6", 210, 255, 2.7, 245, 5.8, 11.5,
                    "5-Speed Manual, Limited Slip Differential", 4.0, 8.5, true)
        );

        carRepository.saveAll(cars);
    }

    private Car createCar(String name, String brand, String type, Integer year,
                         BigDecimal price, String description, String imageUrl,
                         String engineType, Integer horsepower, Integer torque,
                         Double displacement, Integer topSpeed, Double acceleration,
                         Double fuelEconomy, String techFeatures,
                         Double safetyRating, Double performanceRating, Boolean isFeatured) {
        Car car = new Car();
        car.setName(name);
        car.setBrand(brand);
        car.setType(type);
        car.setYear(year);
        car.setPrice(price);
        car.setDescription(description);
        car.setImageUrl(imageUrl);
        car.setEngineType(engineType);
        car.setHorsepower(horsepower);
        car.setTorque(torque);
        car.setDisplacement(displacement);
        car.setTopSpeed(topSpeed);
        car.setAcceleration0To100(acceleration);
        car.setFuelEconomy(fuelEconomy);
        car.setTechFeatures(techFeatures);
        car.setSafetyRating(safetyRating);
        car.setPerformanceRating(performanceRating);
        car.setIsFeatured(isFeatured);
        return car;
    }
}

