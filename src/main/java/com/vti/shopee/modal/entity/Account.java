package com.vti.shopee.modal.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ACCOUNT")
public class    Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "USERNAME",length = 50, unique = true,nullable = false)
    private String name;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "PASSWORD",length = 100,nullable = false)
    private String password;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "ADDRESS",length = 255)
    private String address;

    @Column(name = "FULL_NAME",length = 50)
    private String fullName;

    @Column(name = "PHONE_NUMBER",length = 12)
    private String phoneNumber;

    @Column(name = "EMAIL",length = 50,unique = true,nullable = false)
    private String email;

    @Column(name = "INFORMATION",length = 255)
    private String information;

}
