package com.nu;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReceptionistServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceptionistServiceApplication.class, args);
	}

}
