package com.easy2excel.entity;

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

    @Column(name = "url", length = 60)
    private String url;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Opportunity> opportunities = new ArrayList<>();

}
