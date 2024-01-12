package com.vti.shopee.repository.speacification;

import com.vti.shopee.modal.dto.SearchProductRequest;
import com.vti.shopee.modal.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class Productspecification {

    public static Specification<Product> buildCondition(SearchProductRequest request){
        return Specification.where(buildConditionName(request))
                .and(buildConditionProductType(request))
                    .and(buildConditionProductShippingUnit(request))
                .and(buildConditionProductStatus(request))
                .and(buildConditionPrice(request));

    }

    public static Specification<Product> buildConditionName(SearchProductRequest request){
        if (request.getName() != null && !"".equals(request.getName())){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("name"), "%" + request.getName() + "%");
            };
        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionProductType(SearchProductRequest request){
        if (request.getProductType() != null && request.getProductType().size()>0){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                return root.get("productType").in( request.getProductType());
            };
        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionProductShippingUnit(SearchProductRequest request){
        if (request.getShippingUnit() != null && request.getShippingUnit().size()>0){//neu khong truyen vao ptu nao thi lay tat ca
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                return root.get("shippingUnit").in( request.getShippingUnit());
            };
        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionProductStatus(SearchProductRequest request){
        if (request.getStatus() != null && request.getStatus().size()>0){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                return root.get("status").in( request.getStatus());
            };
        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionPrice(SearchProductRequest request){

        if (request.getMaxPrice() != 0 &&request.getMinPrice() != 0){
            return (root, query, cri) -> {
                return cri.between(root.get("price"), request.getMinPrice(), request.getMaxPrice());
            };
        }
        return null;
    }
}
