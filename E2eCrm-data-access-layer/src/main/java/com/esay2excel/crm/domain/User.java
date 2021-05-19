package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")

public class User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<UserAddress> addresses;
    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.UserGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "user_id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "dial_code")
    private String dialCode;

    @Column(name = "alternative_no")
    private String alternativeNo;

    @Column(name = "dial_code1")
    private String dialCode1;

    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", foreignKey = @ForeignKey(name = "user_org_fk"))
    private Organization organization;

}
