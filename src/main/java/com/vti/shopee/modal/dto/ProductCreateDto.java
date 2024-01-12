package com.vti.shopee.modal.dto;

import com.vti.shopee.config.anotation.NotAdmin;
import com.vti.shopee.modal.entity.ProductStatus;
import com.vti.shopee.modal.entity.ProductType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductCreateDto {

    @NotBlank(message="{product.create.name.notBlank}")
    @NotAdmin
    private String name;
    //điều kiện gì để không bị lỗi
    //khoong bị trùng trong database
    //không bị null
    //không qua dai
    //một số yêu cầu dặcc biệt :không chứa ký tự đặc biệt , trin() đầu cuối
    @NotBlank(message = "anh khong dc de trong")
    private String image;
    private  String price;
    private ProductStatus  status;
    private String  shippingUnit;
    private ProductType productType;
}
