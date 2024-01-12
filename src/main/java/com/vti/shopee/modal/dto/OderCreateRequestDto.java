package com.vti.shopee.modal.dto;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class OderCreateRequestDto {

    private  int productId;

    private int accountId;
    @Positive
    private int quantity;




}
