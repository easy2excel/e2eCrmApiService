package com.easy2excel.crm.controller;

import com.easy2excel.crm.dto.MovieDTO;
import com.easy2excel.crm.dto.view.MovieViewDTO;
import com.esay2excel.crm.domain.Genres;
import com.esay2excel.crm.domain.Movie;
import com.esay2excel.crm.repository.GenresRepository;
import com.esay2excel.crm.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Validated
@RequestMapping("/movie")
public class MovieController extends BaseController<Movie, MovieDTO, MovieViewDTO> {
    final GenresRepository genresRepository;

    public MovieController(MovieRepository movieRepository, GenresRepository genresRepository) {
        super(movieRepository, "movie");
        this.genresRepository = genresRepository;
    }

    @Override
    Movie createBaseEntity() {
        return new Movie();
    }

    @Override
    void setPropertiesOnInput(MovieDTO input, Movie fromDb) {
        fromDb.setName(input.getName());
        fromDb.setFullName(input.getFullName());
        fromDb.setDescription(input.getDescription());
        fromDb.setAdult(input.getAdult());
        fromDb.setStartYear(input.getStartYear());
        fromDb.setEndYear(input.getEndYear());
        fromDb.setTimeDuration(input.getTimeDuration());
        Set<Genres> genresSet = input.getGenres().stream().map(genresId -> {
            return genresRepository.findById(genresId).map(genres -> genres).orElse(null);
        }).collect(Collectors.toSet());

        fromDb.setGenres(genresSet);
    }

    @Override
    MovieViewDTO setPropertiesOnViewEntityDTO(Movie movie, boolean setExtendedProperties) {
        return MovieViewDTO.from(movie, true);
    }
}
