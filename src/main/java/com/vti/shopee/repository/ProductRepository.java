package com.vti.shopee.repository;

import com.vti.shopee.modal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface    ProductRepository extends JpaRepository<Product,Integer> , JpaSpecificationExecutor<Product> {
}
