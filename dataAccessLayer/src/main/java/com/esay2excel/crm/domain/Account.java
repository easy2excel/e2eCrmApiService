package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account_details", uniqueConstraints = {
        @UniqueConstraint(
                name = "account_ident_unq",
                columnNames = {"account_id"}
        )})
@Getter
@Setter
@ToString
public class Account extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountIdSeq")
    @SequenceGenerator(name = "AccountIdSeq", sequenceName = "account_id_seq", allocationSize = 10)
    @Column(name = "account_id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "website", length = 60)
    private String website;

    @Column(name = "tickerSymbol", length = 60)
    private String tickerSymbol;

    @Column(name = "tradeCurrency", length = 60)
    private String tradeCurrency;

    @Column(name = "companyType", length = 60)
    private String companyType;

    @Column(name = "industryType", length = 60)
    private String industryType;

    @Column(name = "baseCurrency", length = 60)
    private String baseCurrency;

    @Column(name = "rating", length = 60)
    private String rating;

    @Column(name = "revenue", length = 60)
    private String revenue;

    @Column(name = "description", length = 60)
    private String description;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Opportunity> opportunities = new ArrayList<>();

}
