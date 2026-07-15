package com.professionalit.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.professionalit.event.ProductEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductProducer {


    private final KafkaTemplate<String,ProductEvent> kafkaTemplate;


    public void send(ProductEvent event){

        kafkaTemplate.send(
            "product-topic",
            event.getId().toString(),
            event
        );

    }

}