package com.easy2excel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class OpportunityDTO extends BaseDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
}
