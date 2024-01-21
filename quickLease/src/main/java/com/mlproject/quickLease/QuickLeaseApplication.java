package com.mlproject.quickLease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class QuickLeaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickLeaseApplication.class, args);
	}

}
