package com.easy2excel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountDTO extends BaseDTO {
    @NotBlank
    private String name;
    @NotNull
    private Long accountId;

}
