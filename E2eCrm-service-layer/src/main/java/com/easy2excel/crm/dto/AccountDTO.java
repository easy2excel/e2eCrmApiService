package com.easy2excel.crm.dto;

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
    private Long Id;
    private String website;
    private String tickerSymbol;
    @NotNull
    private String tradeCurrency;
    private String companyType;
    private String industryType;
    @NotNull
    private String baseCurrency;
    private String rating;
    private String revenue;
    private String description;
}