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
@Table(name = "organization")

public class Organization {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.OrganizationGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "org_id")
    private String id;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "country")
    private String country;

    @Column(name = "url")
    private String url;

    @Column(name = "company_size")
    private String companySize;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "dial_code")
    private String dialCode;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> user;

}
