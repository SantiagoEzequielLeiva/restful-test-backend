package com.sl.sbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.sl.sbdemo.controladores","com.sl.sbdemo.dao","com.sl.sbdemo.servicios"})
@SpringBootApplication
public class SbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbDemoApplication.class, args);
	}
}