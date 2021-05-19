package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user_settings")

public class UserSettings {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.UserSettingsGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "user_settings_id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "email")
    private String email;

    @Column(name = "user_active_ind")
    private boolean userActiveInd;

    @Column(name = "email_val_ind")
    private boolean emailValInd;

    @Column(name = "password_active_ind")
    private boolean passwordActiveInd;
}
