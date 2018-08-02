package com.skytask.service;

import com.skytask.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductService implements IProductService {

    private List<Product> products;

    public List<Product> getList() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
