package com.neebal.practisespringcore;

import com.neebal.practisespringcore.service.SurpriseMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PractiseSpringCoreApplication implements CommandLineRunner {

	@Autowired
	private SurpriseMeService surpriseMeService;
	@Autowired
	private SurpriseMeService surpriseMeService2;

	public static void main(String[] args) {
		SpringApplication.run(PractiseSpringCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println(String.format("welcome username %s",username));
			System.out.println("Your surprise me random movie is:");
//			System.out.println(new SurpriseMeService().getMovie()); NOT IN SPRING PLS
			System.out.println(this.surpriseMeService.getMovie());


		}

	}
}
