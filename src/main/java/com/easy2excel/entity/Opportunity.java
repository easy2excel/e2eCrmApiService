package com.easy2excel.entity;

import com.easy2excel.entity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "opportunity_details")
@Setter
@Getter
@ToString
public class Opportunity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OpportunityIdSeq")
    @SequenceGenerator(name = "OpportunityIdSeq", sequenceName = "opportunity_id_seq", allocationSize = 10)
    @Column(name = "opportunity_id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "opportunity_name", nullable = false)
    private String opportunity_name;

    @ManyToOne
    @JoinColumn(name = "account_id",foreignKey = @ForeignKey(name = "account_fk"))
    private Account account;

}
