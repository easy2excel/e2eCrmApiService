package com.easy2excel.crm.controller;

import com.easy2excel.crm.dto.GenresDTO;
import com.easy2excel.crm.dto.view.GenresViewDTO;
import com.esay2excel.crm.domain.Genres;
import com.esay2excel.crm.repository.GenresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequestMapping("/genres")
public class GenresController extends BaseController<Genres, GenresDTO, GenresViewDTO> {

    public GenresController(GenresRepository genresRepository) {
        super(genresRepository, "genres");
    }

    @Override
    Genres createBaseEntity() {
        return new Genres();
    }

    @Override
    void setPropertiesOnInput(GenresDTO input, Genres fromDb) {
        fromDb.setName(input.getName());
    }

    @Override
    GenresViewDTO setPropertiesOnViewEntityDTO(Genres jpaEntity, boolean setExtendedProperties) {
        return GenresViewDTO.from(jpaEntity, setExtendedProperties);
    }
}
