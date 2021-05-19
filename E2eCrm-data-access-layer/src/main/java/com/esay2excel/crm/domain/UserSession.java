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
@Table(name = "user_session")

public class UserSession {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.UserSessionGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "user_session_id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "login_time")
    private long loginTime;

    @Column(name = "logout_time")
    private long logoutTime;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "token")
    private String token;

    @Column(name = "email")
    private String email;

}
