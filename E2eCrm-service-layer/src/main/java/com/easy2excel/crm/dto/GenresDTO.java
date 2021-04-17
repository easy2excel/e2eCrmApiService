package com.easy2excel.crm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GenresDTO extends BaseDTO {

    @NotBlank
    private String name;
}
