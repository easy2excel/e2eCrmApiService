package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "movie", uniqueConstraints = {
        @UniqueConstraint(
                name = "movie_ident_unq",
                columnNames = {"movie_id"}
        )})
@Getter
@Setter
@ToString
public class Movie extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "full_name", length = 250)
    private String fullName;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "adult")
    private Boolean adult;

    @Column(name = "satrt_year")
    private LocalDate startYear;

    @Column(name = "end_year")
    private LocalDate endYear;

    @Column(name = "time_duration")
    private Integer timeDuration;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_genres_link",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "genres_id") })
    private Set<Genres> genres;

}
