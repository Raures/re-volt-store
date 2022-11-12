package com.example.demo.models;

import org.springframework.data.annotation.Reference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer thumbnail_id;
    private Integer engine_id;
    private Integer rating_id;
    private Integer speed;
    private Double acc;
    private Double mass;

    public Car() {}

    public Car(Long id, String name, Integer thumbnail_id, Integer engine_id, Integer rating_id, Integer speed, Double acc, Double mass) {
        this.id = id;
        this.name = name;
        this.thumbnail_id = thumbnail_id;
        this.engine_id = engine_id;
        this.rating_id = rating_id;
        this.speed = speed;
        this.acc = acc;
        this.mass = mass;
    }

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

    public Integer getThumbnail_id() {
        return thumbnail_id;
    }

    public void setThumbnail_id(Integer thumbnail_id) {
        this.thumbnail_id = thumbnail_id;
    }

    public Integer getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(Integer engine_id) {
        this.engine_id = engine_id;
    }

    public Integer getRating_id() {
        return rating_id;
    }

    public void setRating_id(Integer rating_id) {
        this.rating_id = rating_id;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Double getAcc() {
        return acc;
    }

    public void setAcc(Double acc) {
        this.acc = acc;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }
}
