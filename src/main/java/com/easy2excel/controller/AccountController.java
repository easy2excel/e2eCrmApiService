package com.easy2excel.controller;

import com.easy2excel.dto.AccountDTO;
import com.easy2excel.dto.AccountViewDTO;
import com.easy2excel.entity.Account;
import com.easy2excel.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequestMapping("/account")
public class AccountController extends BaseController<Account, AccountDTO, AccountViewDTO> {

    public AccountController(final AccountRepository accountRepository) {
        super(accountRepository, "account");
    }

    @Override
    Account createBaseEntity() {
        return new Account();
    }

    @Override
    void setPropertiesOnInput(final AccountDTO input, final Account account) {
        account.setName(input.getName());
        account.setBaseCurrency(input.getBaseCurrency());
        account.setCompanyType(input.getCompanyType());
        account.setDescription(input.getDescription());

    }

    @Override
    AccountViewDTO setPropertiesOnViewEntityDTO(final Account account, boolean setExtendedProperties) {
        return AccountViewDTO.from(account,setExtendedProperties);
    }
}
