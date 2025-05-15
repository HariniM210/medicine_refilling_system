package com.MedRef.MedApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.MedRef.MedApp.model")
public class MedAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedAppApplication.class, args);
	}

}
