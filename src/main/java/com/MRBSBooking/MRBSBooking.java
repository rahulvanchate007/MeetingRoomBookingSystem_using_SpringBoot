package com.MRBSBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.MRBSBooking"})
@EntityScan(basePackages = {"com.MRBSBooking"})
@EnableJpaRepositories(basePackages = {"com.MRBSBooking"})

@SpringBootApplication
public class MRBSBooking {

	public static void main(String[] args) {
		SpringApplication.run(MRBSBooking.class, args);
	}

}
