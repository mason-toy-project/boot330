package com.mason.practice.boot330;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Boot330Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Boot330Application.class, args);
		Environment env = ctx.getBean(Environment.class);

		for (String profile : env.getActiveProfiles()) {
			System.out.println(profile);
		}


		// I want to print all property in application-local.yml



	}

}
