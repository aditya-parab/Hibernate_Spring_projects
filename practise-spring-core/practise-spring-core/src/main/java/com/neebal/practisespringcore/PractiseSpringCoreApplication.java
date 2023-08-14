package com.neebal.practisespringcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PractiseSpringCoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PractiseSpringCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println();
		}

	}
}
