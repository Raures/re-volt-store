package com.example.demo.repository;

import com.example.demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT wishlisted FROM cars WHERE id = ?1 ;", nativeQuery = true)
    public Boolean getWishlistStatus(Long id);

    @Transactional // TODO: Research @Transactional
    @Modifying // TODO: Research @Modifying
    @Query(value = "UPDATE cars SET wishlisted = ?2 WHERE id = ?1 ;", nativeQuery = true)
    public void updateWishlistedStatusById(Long id, Boolean status);

    @Query(value = "SELECT * FROM cars WHERE wishlisted = ?1 ;", nativeQuery = true)
    public List<Car> getAllWithWishlistStatus(Boolean status);

}
