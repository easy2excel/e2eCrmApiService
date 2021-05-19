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
@Table(name = "cart_iteam")

public class CartItem {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.CartItemGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "cart_id")
    private String id;

    @Column(name = "token")
    private String token;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private float discount;

    @Column(name = "amount")
    private float amount;


}
