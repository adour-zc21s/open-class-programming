package com.adour.openclassprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class OpenclassprogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenclassprogApplication.class, args);
	}

}
