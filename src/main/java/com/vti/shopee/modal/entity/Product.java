package com.vti.shopee.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME",length = 255,unique = true,nullable = false)
    private String name;

    @Column(name = "IMAGE",unique = true,nullable = false)
    private String image;

    @Column(name = "PRICE",nullable = false)
    private  String price;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProductStatus  status;

    @Enumerated(EnumType.STRING)
    @Column(name = "SHIPPING_UNIT")
    private ShippingUnit  shippingUnit;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private ProductType productType;


}
