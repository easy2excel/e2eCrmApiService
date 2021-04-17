package com.easy2excel.crm.dto.view;

import com.esay2excel.crm.domain.Auditable;
import com.esay2excel.crm.domain.Genres;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class GenresViewDTO extends BaseViewDTO {

    Set<MovieViewDTO> movies;
    private Long id;
    private String name;

    public GenresViewDTO(Auditable auditable, final Long id, final String name, boolean setTimeFields) {
        super(auditable, setTimeFields);
        this.id = id;
        this.name = name;
    }

    public static GenresViewDTO from(Genres genres, Boolean setExtendedProperties) {
        GenresViewDTO genresViewDTO = null;
        if (genres == null) {
            genresViewDTO = null;
        } else {
            genresViewDTO = new GenresViewDTO(genres, genres.getId(), genres.getName(), setExtendedProperties);
            if (setExtendedProperties) {
                Set<MovieViewDTO> movieViewDTOS = genres.getMovies().stream().map(movie -> {
                    return MovieViewDTO.from(movie, false);
                }).collect(Collectors.toSet());
                genresViewDTO.setMovies(movieViewDTOS);
            }
        }
        return genresViewDTO;
    }
}
