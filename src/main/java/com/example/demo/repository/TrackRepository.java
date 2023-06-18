package com.example.demo.repository;

import com.example.demo.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "SELECT wishlisted FROM tracks WHERE id = ?1 ;", nativeQuery = true)
    Boolean getWishlistStatus(Long id);

    @Query(value = "UPDATE tracks SET wishlisted = ?2 WHERE id = ?1 ;", nativeQuery = true)
    void updateWishlistedStatusById(Long id, Boolean status);

    @Query(value = "SELECT * FROM tracks WHERE wishlisted = ?1 ;", nativeQuery = true)
    List<Track> getAllWithWishlistStatus(Boolean status);
}
