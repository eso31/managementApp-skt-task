package com.skytask.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProductSource {

    @Output("createProductChannel")
    MessageChannel createProduct();

    @Output("requestProductListChannel")
    MessageChannel getProductList();

    @Input("responseProductListChannel")
    SubscribableChannel hearProductList();
}
