package com.esay2excel.crm.repository;


import com.esay2excel.crm.domain.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingsRepository extends JpaRepository<UserSettings, String> {
    @Query(value = "select a  from UserSettings a  where a.email=:email" )
    public UserSettings getUserSettingsByEmail(@Param(value="email")String email);

}
