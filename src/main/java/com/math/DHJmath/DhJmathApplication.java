package com.math.DHJmath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class DhJmathApplication {

	public static void main(String[] args) {
		SpringApplication.run(DhJmathApplication.class, args);
	}

	// PutMapping, DeleteMapping을 위한 Bean
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}

}
