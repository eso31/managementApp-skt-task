package com.skytask.service;

import com.skytask.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getList();

    void create(Product product);

    void setProducts(List<Product> products);
}
