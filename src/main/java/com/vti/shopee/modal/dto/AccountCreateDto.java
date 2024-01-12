package com.vti.shopee.modal.dto;

import lombok.Data;

@Data
public class AccountCreateDto {

    private String  name;

    private String password;

    private String dateOfBirth;

    private String  address;

    private String phoneNumber;

    private String email;

    private String information;
}
