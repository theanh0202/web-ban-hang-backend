package com.vti.shopee.service.iml;



import com.vti.shopee.modal.dto.BaseRequest;
import com.vti.shopee.modal.dto.ProductCreateDto;
import com.vti.shopee.modal.dto.ProductUpdateDto;
import com.vti.shopee.modal.dto.SearchProductRequest;
import com.vti.shopee.modal.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product create(ProductCreateDto dto);

    Product getById(int id);

    Product update(ProductUpdateDto dto);

    Product delete(int id);

    Page<Product> search(SearchProductRequest request);
}
