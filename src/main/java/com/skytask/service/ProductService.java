package com.skytask.service;

import com.skytask.model.Product;
import com.skytask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository _productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    public List<Product> getList() {
        return _productRepository.findAll();
    }

    public void create(Product product) {
        _productRepository.saveAndFlush(product);
    }
}
