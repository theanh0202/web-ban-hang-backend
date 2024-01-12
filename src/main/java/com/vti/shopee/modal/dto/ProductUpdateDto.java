package com.vti.shopee.modal.dto;

import com.vti.shopee.modal.entity.ProductStatus;
import com.vti.shopee.modal.entity.ProductType;
import lombok.Data;

@Data

public class ProductUpdateDto {
    private int id;
    private String name;
    private String image;
    private  String price;
    private ProductStatus status;
    private String  shippingUnit;
    private ProductType productType;
}
