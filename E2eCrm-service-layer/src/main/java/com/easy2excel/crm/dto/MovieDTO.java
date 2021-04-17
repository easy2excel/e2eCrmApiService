package com.easy2excel.crm.dto;

import com.esay2excel.crm.domain.GenresType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieDTO extends BaseDTO {
    @NotBlank
    private String name;
    private String fullName;
    private String description;
    private Boolean adult;
    private LocalDate startYear;
    private LocalDate endYear;
    private Integer timeDuration;
    private Set<Long> genres;
}
