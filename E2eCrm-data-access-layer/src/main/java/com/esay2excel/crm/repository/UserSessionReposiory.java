package com.esay2excel.crm.repository;


import com.esay2excel.crm.domain.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionReposiory extends JpaRepository<UserSession, String>{

}
