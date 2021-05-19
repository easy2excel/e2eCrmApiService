package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "invoice")
public class Invoice {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.InvoiceGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "invoice_id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "invoice_date")
    private Date invoiceDate;

}
