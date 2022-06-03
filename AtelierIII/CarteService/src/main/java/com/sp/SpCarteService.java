package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpCarteService {
	
	public static void main(String[] args) {
		System.getProperties().put("server.port",3080);
		SpringApplication.run(SpCarteService.class,args);
	}
}
