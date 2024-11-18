package com.golfapi.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		String exit = input.nextLine();
		while(true){
			if(exit.equals("1")){
				System.exit(0);
			}
		}
	}
}
