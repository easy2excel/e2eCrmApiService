package com.easy2excel.crm.dto.view;

import com.esay2excel.crm.domain.Auditable;
import com.esay2excel.crm.domain.Movie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class MovieViewDTO extends BaseViewDTO {
    private Long id;
    private String name;
    private String fullName;
    private String description;
    private Boolean adult;
    private LocalDate startYear;
    private LocalDate endYear;
    private Integer timeDuration;
    private Set<GenresViewDTO> genres;

    public MovieViewDTO(Auditable auditable, Long id, String name, String fullName, String description, Boolean adult, LocalDate startYear, LocalDate endYear, Integer timeDuration, boolean setTimeFields) {
        super(auditable, setTimeFields);
        this.id = id;
        this.name = name;
        this.description = description;
        this.adult = adult;
        this.startYear = startYear;
        this.endYear = endYear;
        this.timeDuration = timeDuration;
    }

    public static MovieViewDTO from(Movie movie, Boolean setExtendedProperties) {
        MovieViewDTO movieViewDTO;
        if (movie == null) {
            movieViewDTO = null;
        } else {
            movieViewDTO = new MovieViewDTO(movie, movie.getId(), movie.getName(), movie.getFullName(), movie.getDescription(), movie.getAdult(), movie.getStartYear(), movie.getEndYear(), movie.getTimeDuration(), setExtendedProperties);
            if (setExtendedProperties) {
                Set<GenresViewDTO> genresviewDTOS = movie.getGenres().stream().map(genres -> {
                    return GenresViewDTO.from(genres, false);
                }).collect(Collectors.toSet());
                movieViewDTO.setGenres(genresviewDTOS);
            }
        }
        return movieViewDTO;
    }
}
