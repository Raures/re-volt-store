package com.example.demo;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReVoltStoreApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void findWishlistedCars() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        List<Car> wishlistedCars = carRepository.getAllWithWishlistStatus(true);
        for (Car car : wishlistedCars) {
            assertTrue(car.getWishlisted());
        }
    }

    @Test
    void findNonWishlistedCars() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        List<Car> nonWishlistedCars = carRepository.getAllWithWishlistStatus(true);
        for (Car car : nonWishlistedCars) {
            assertFalse(car.getWishlisted());
        }
    }
}
