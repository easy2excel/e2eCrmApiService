package com.easy2excel.crm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.easy2excel.crm")
@Slf4j
public class E2ecrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(E2ecrmApplication.class, args);
	}

}
