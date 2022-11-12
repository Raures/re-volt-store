package com.example.demo.repository;

import com.example.demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM cars WHERE LOWER(name) = LOWER(:name)", nativeQuery = true)
    Car findByName(@Param("name") String name);
}
