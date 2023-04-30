package com.simplilearn.sporty.shoes.repository;

import com.simplilearn.sporty.shoes.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByCategoryIdAndProductName(Integer cId, String productName);
}
