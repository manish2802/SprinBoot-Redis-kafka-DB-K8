package com.professionalit.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.professionalit.event.ProductEvent;

@Service
public class ProductConsumer {


    @KafkaListener(
        topics="product-topic",
        groupId="product-group"
    )
    public void consume(ProductEvent event){


        System.out.println(
            "Kafka Event Received : "
            + event
        );

    }

}