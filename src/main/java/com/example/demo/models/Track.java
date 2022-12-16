package com.example.demo.models;

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
@Table(name = "tracks")
public class Track {
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
    @JoinColumn(name = "difficulty_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    private Difficulty difficulty;

    @Column(name = "length")
    private Integer length;
}
