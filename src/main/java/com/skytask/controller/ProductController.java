package com.skytask.controller;

import com.skytask.model.Product;
import com.skytask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    private ProductService _productService;

    @Autowired
    public ProductController(ProductService productService) {
        _productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        List<Product> products = _productService.getList();
        return new ModelAndView("index", "products", products);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createform() {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(Product product) {
        _productService.create(product);
        return new ModelAndView("redirect:/");
    }
}
