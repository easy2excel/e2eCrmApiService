package com.easy2excel.crm.dto.view;

import com.esay2excel.crm.domain.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountViewDTO extends BaseViewDTO {
    private Long id;
    private String name;
    private String website;
    private String tickerSymbol;
    private String tradeCurrency;
    private String companyType;
    private String industryType;
    private String baseCurrency;
    private String rating;
    private String revenue;
    private String description;

    public AccountViewDTO(Auditable auditable, final Long id, final String name, boolean setTimeFields) {
        super(auditable, setTimeFields);
        this.id = id;

        this.name = name;
    }

    /*public static AccountViewDTO from(Account account, final boolean setExtendedProperties) {

        AccountViewDTO accountViewDTO;
        if (account == null) {
            accountViewDTO = null;
        } else {
            accountViewDTO = new AccountViewDTO(account, account.getId(), account.getName(), setExtendedProperties);
        }
        return accountViewDTO;
    }*/
}
