package com.tax24.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class mainApplication {
	public static void main(String[] args) {
		SpringApplication.run(mainApplication.class, args);
	}
}
