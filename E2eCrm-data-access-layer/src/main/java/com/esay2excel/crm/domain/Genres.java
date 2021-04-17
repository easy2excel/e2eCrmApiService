package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres", uniqueConstraints = {
        @UniqueConstraint(
                name = "genres_ident_unq",
                columnNames = {"genres_id"}
        )})
@Getter
@Setter
@ToString
public class Genres extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genres_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @ManyToMany(mappedBy = "genres",fetch = FetchType.EAGER)
    private Set<Movie> movies;

}
