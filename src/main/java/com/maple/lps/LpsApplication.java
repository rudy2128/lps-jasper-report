package com.maple.lps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@SpringBootApplication
public class LpsApplication {

	public static void main(String[] args)throws Exception {
		SpringApplication.run(LpsApplication.class, args);
	}

}
