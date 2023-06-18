package com.revoltstore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thumbnail_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    private Thumbnail thumbnail;

    @OneToOne
    @JoinColumn(name = "engine_id")
    @MapsId("id")
    private Engine engine;

    @OneToOne
    @JoinColumn(name = "rating_id")
    @MapsId("id")
    private Rating rating;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "acc")
    private Double acc;

    @Column(name = "mass")
    private Double mass;

    @Column(name = "price")
    private Double price;

    @Column(name = "wishlisted")
    private Boolean wishlisted;

    @Column(name = "carted")
    private Boolean carted;
}
