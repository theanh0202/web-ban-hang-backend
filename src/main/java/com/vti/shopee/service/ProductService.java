package com.vti.shopee.service;

import com.vti.shopee.config.exception.AppException;
import com.vti.shopee.config.exception.ErrorResponseEnum;
import com.vti.shopee.modal.dto.BaseRequest;
import com.vti.shopee.modal.dto.ProductCreateDto;
import com.vti.shopee.modal.dto.ProductUpdateDto;
import com.vti.shopee.modal.dto.SearchProductRequest;
import com.vti.shopee.modal.entity.Product;
import com.vti.shopee.repository.ProductRepository;
import com.vti.shopee.repository.speacification.Productspecification;
import com.vti.shopee.service.iml.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductCreateDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return productRepository.save(product);
    }

    @Override
    public Product update(ProductUpdateDto dto) {
        Optional<Product> productOptional = productRepository.findById(dto.getId());
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            BeanUtils.copyProperties(dto, product);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product getById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            return productOptional.get();
        }
        throw new AppException(ErrorResponseEnum.NOT_FOUND_PRODUCT);
    }

    @Override
    public Product delete(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            productRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public Page<Product> search(SearchProductRequest request) {
        PageRequest pageRequest = null;
        if ("DESC".equals(request.getSortField())){
            // Giá trị page mà thư viện mong muốn để vào trang đầu tiên: 0
            // Giá trị mình muốn để lấy trang đầu tiền: 1 - 1
            pageRequest = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.by(request.getSortField()).descending());
        } else {
            pageRequest = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.by(request.getSortField()).ascending());
        }
        Specification<Product> condition= Productspecification.buildCondition(request);
        return productRepository.findAll(condition,pageRequest);
    }
}
