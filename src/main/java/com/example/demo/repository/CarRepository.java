package com.example.demo.repository;

import com.example.demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT wishlisted FROM cars WHERE id = ?1 ;", nativeQuery = true)
    Boolean getWishlistStatus(Long id);

    @Query(value = "UPDATE cars SET wishlisted = ?2 WHERE id = ?1 ;", nativeQuery = true)
    void updateWishlistedStatusById(Long id, Boolean status);

    @Query(value = "SELECT * FROM cars WHERE wishlisted = ?1 ;", nativeQuery = true)
    List<Car> getAllWithWishlistStatus(Boolean status);

}
