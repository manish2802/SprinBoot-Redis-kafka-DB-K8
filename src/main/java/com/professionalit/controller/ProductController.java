package com.professionalit.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professionalit.entity.Product;
import com.professionalit.service.ProductService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;



    @PostMapping
    public Product create(
            @RequestBody Product product){

        return service.save(product);

    }



    @GetMapping("/{id}")
    public Product get(
        @PathVariable Long id){

        return service.findById(id);

    }



    @DeleteMapping("/{id}")
    public String delete(
        @PathVariable Long id){


        service.delete(id);

        return "Deleted";

    }

}