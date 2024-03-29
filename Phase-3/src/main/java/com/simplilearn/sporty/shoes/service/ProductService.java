package com.simplilearn.sporty.shoes.service;

import com.simplilearn.sporty.shoes.model.Product;
import com.simplilearn.sporty.shoes.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean insertProduct(Product product) {
        try {
            log.info("[insertProduct] started! product will be inserted! :: product ={}", product);
            if (!isProductAlreadyExist(product)) {
                productRepository.save(product);
                log.info("[insertProduct] new product inserted! :: product ={}", product);
                return true;
            }
        } catch (Exception e) {
            log.error("[insertProduct] Exception occurred! Product could not be added!");
        }
        return false;
    }

    private boolean isProductAlreadyExist(Product product) {
        try {
            log.info("[isProductAlreadyExist] started! existence will be checked! :: product ={}", product);
            boolean exists = productRepository.existsByCategoryIdAndProductName(product.getCategoryId(),
                                                                                product.getProductName());
            return exists;
        } catch (DataAccessException dataAccessException) {
            log.error("[isProductAlreadyExist] Exception occurred while getting data from db!", dataAccessException);
        } catch (Exception e) {
            log.error("[isProductAlreadyExist] Exception occurred!", e);
        }
        return true;
    }
}
