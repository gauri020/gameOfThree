package org.gauri.assignment.gameofthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GameOfThreeApplication {  

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(GameOfThreeApplication.class);
		ApplicationContext ctx =application.run(args);			
	}
		
}  
