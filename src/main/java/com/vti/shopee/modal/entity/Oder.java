package com.vti.shopee.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`ODER`")
public class Oder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ODER_BY")//ten cot cau khoa ngoai trong database
    private Account account;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "ODER_STATUS")
    private Status status;


}
