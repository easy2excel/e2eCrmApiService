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
@Table(name = "order_product_link")
public class OrderProductLink {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.OrderProductLinkGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "order_product_link_id")
    private String id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "product_id")
    private String productId;


}
