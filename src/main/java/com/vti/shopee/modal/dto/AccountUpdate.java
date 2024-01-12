package com.vti.shopee.modal.dto;

import lombok.Data;

@Data
public class AccountUpdate {
    private int id;

    private String  name;

    private String password;

    private String dateOfBirth;

    private String  address;

    private String phoneNumber;

    private String email;

    private String information;
}
