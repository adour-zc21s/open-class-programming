package com.adour.openclassprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OpenclassprogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenclassprogApplication.class, args);
	}

}
