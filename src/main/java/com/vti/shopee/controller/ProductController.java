package com.vti.shopee.controller;

import com.vti.shopee.config.anotation.ProductIDExists;
import com.vti.shopee.modal.dto.BaseRequest;
import com.vti.shopee.modal.dto.ProductCreateDto;
import com.vti.shopee.modal.dto.ProductUpdateDto;
import com.vti.shopee.modal.dto.SearchProductRequest;
import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Oder;
import com.vti.shopee.modal.entity.Product;
import com.vti.shopee.service.AccountService;
import com.vti.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("*")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public List<Product> getall(){
        return productService.getAll();
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchProductRequest request){
        return productService.search(request);
    }

    @PostMapping("/create")
    public Product create(@RequestBody @Valid ProductCreateDto dto){
        return productService.create(dto);
    }

    @GetMapping("{id}")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PutMapping("/update")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN','SELLER')")
    //http://localhost:8080/api/v1/account/update
    public Product update(@RequestBody ProductUpdateDto dto){
        return productService.update(dto);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public Product delete(@PathVariable int id){
        return productService.delete(id);
    }
}
