package com.easy2excel.crm.controller;


import com.easy2excel.crm.dto.AccountDTO;
import com.easy2excel.crm.dto.view.AccountViewDTO;
import com.esay2excel.crm.domain.Account;
import com.esay2excel.crm.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
