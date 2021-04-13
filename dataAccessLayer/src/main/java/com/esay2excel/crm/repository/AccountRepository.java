package com.esay2excel.crm.repository;


import com.esay2excel.crm.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
