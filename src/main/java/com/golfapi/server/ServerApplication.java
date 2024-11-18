package com.golfapi.server;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class ServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
