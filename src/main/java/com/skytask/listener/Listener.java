package com.skytask.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.skytask.channel.ProductSource;
import com.skytask.model.Product;
import com.skytask.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.io.IOException;
import java.util.List;

@EnableBinding(ProductSource.class)
public class Listener {

    private static Logger logger = LoggerFactory.getLogger(Listener.class);

    @Autowired
    private IProductService productService;

    @StreamListener("productListChannelInput")
    public void updateProductList(String products) throws IOException {
        logger.info("I received: " + products);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Product.class);
        productService.setProducts(mapper.readValue(products, type));
    }
}
