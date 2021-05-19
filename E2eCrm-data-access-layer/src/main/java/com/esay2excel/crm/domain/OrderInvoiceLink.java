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
@Table(name = "order_invoice_link")
public class OrderInvoiceLink {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.OrderInvoiceLinkGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "order_invoice_id")
    private String id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "invoice_id")
    private String invoiceId;
}
