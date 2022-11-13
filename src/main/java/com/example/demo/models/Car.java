package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "thumbnail_id")
    private Integer thumbnail_id;
    @Column(name = "engine_id")
    private Integer engine_id;
    @Column(name = "rating_id")
    private Integer rating_id;
    @Column(name = "speed")
    private Integer speed;
    @Column(name = "acc")
    private Double acc;
    @Column(name = "mass")
    private Double mass;
}
