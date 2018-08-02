package com.skytask.service;

import com.skytask.model.Product;
import com.skytask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductService implements IProductService{

    private ProductRepository productRepository;
    private List<Product> products;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getList() {
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.saveAndFlush(product);
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }
}
