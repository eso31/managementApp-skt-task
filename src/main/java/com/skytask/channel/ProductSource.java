package com.skytask.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProductSource {

    @Output("productsChannelOutput")
    MessageChannel productsOutput();

    @Output("productListChannelOutput")
    MessageChannel productListOutput();

    @Input("productListChannelInput")
    SubscribableChannel productListInput();
}
