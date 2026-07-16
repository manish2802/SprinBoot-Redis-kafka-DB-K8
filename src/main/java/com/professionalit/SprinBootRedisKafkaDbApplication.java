package com.professionalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SprinBootRedisKafkaDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinBootRedisKafkaDbApplication.class, args);
	}

}
