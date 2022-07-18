package com.gli.hiring.hiring.gli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HiringGliApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringGliApplication.class, args);
	}
}
