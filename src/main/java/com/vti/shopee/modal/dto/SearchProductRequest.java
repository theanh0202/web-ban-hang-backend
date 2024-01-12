package com.vti.shopee.modal.dto;

import com.vti.shopee.modal.entity.ProductStatus;
import com.vti.shopee.modal.entity.ProductType;
import com.vti.shopee.modal.entity.ShippingUnit;
import com.vti.shopee.modal.entity.Status;
import lombok.Data;

import java.util.Set;

@Data
public class SearchProductRequest extends BaseRequest{
    private String name;
    private int minPrice;
    private  int maxPrice;
    private Set<ProductStatus> status;
    private Set<ShippingUnit>  shippingUnit;
    private Set<ProductType> productType;//set khong luu duoc cac doi tuong giong nhau,List luu duoc ca cac doi tuong giong nhau
}
