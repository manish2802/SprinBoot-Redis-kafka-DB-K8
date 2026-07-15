package com.professionalit.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.professionalit.entity.Product;
import com.professionalit.event.ProductEvent;
import com.professionalit.kafka.ProductProducer;
import com.professionalit.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;

    private final ProductProducer producer;

    @CachePut(
        value="products",
        key="#product.id"
    )
    public Product save(Product product){


        Product saved =
                repository.save(product);



        ProductEvent event =
            new ProductEvent(
                saved.getId(),
                saved.getName(),
                saved.getPrice()
            );


        producer.send(event);



        return saved;

    }



    @Cacheable(
        value="products",
        key="#id"
    )
    public Product findById(Long id){


        System.out.println(
          "Fetching from database"
        );


        return repository
            .findById(id)
            .orElseThrow();

    }



    @CacheEvict(
        value="products",
        key="#id"
    )
    public void delete(Long id){

        repository.deleteById(id);

    }


}