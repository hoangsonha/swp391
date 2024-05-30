package com.group6.swp391.service;

import com.group6.swp391.model.Product;
import com.group6.swp391.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired private ProductRepository productRepository;

    @Override
    public Product getProductByProductName(String productName) {
        return productRepository.getProductsByProductName(productName);
    }

    @Override
    public Product getProductByProductID(String productID) {
        return productRepository.getProductsByProductID(productID);
    }

}