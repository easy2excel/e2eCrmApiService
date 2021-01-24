package com.easy2excel.dto;

import com.easy2excel.entity.Account;
import com.easy2excel.entity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountViewDTO extends BaseViewDTO {
    private Long id;
    private String name;

    public AccountViewDTO(Auditable auditable, final Long id, final String name, boolean setTimeFields) {
        super(auditable, setTimeFields);
        this.id = id;

        this.name = name;
    }

    public static AccountViewDTO from(Account account, final boolean setExtendedProperties) {

        AccountViewDTO accountViewDTO;
        if (account == null) {
            accountViewDTO = null;
        } else {
            accountViewDTO = new AccountViewDTO(account, account.getId(), account.getName(), setExtendedProperties);
        }
        return accountViewDTO;
    }
}
