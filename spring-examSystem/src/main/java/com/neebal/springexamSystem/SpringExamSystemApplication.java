package com.neebal.springexamSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExamSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringExamSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello the application has started!");
	}
}
