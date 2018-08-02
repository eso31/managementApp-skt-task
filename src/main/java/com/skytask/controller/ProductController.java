package com.skytask.controller;

import com.skytask.channel.ProductSource;
import com.skytask.model.Product;
import com.skytask.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
class ProductController {

    private IProductService productService;
    private ProductSource productSource;
    private Tracer tracer;

    public ProductController(IProductService productService, ProductSource productSource, Tracer tracer) {
        this.productService = productService;
        this.productSource = productSource;
        this.tracer = tracer;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        List<Product> products = productService.getList();
        return new ModelAndView("index", "products", products);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createform() {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(Product product) {
        productService.create(product);
        return new ModelAndView("redirect:/");
    }
}
