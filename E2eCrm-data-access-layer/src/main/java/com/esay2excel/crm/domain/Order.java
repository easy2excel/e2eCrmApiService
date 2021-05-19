package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order_details")
public class Order {

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<OrderAddress> addresses;
    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.OrderGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "order_id")
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "org_id")
    private String orgId;
    @Column(name = "price")
    private float price;
    @Column(name = "discount")
    private float discount;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "status")
    private String status;
}
