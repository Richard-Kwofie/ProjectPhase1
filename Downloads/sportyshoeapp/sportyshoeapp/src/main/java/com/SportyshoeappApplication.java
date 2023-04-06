package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.repository")
@EntityScan(basePackages = "com.bean")
public class SportyshoeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoeappApplication.class, args);
		System.out.println("spring boot up");
	}

}