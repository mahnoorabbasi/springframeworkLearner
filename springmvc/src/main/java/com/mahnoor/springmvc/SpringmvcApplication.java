package com.mahnoor.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringmvcApplication.class, args);
//		System.out.println("Beans ********");
//		System.out.println(ctx.getBeanDefinitionCount());
//		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(x -> System.out.println(x));

	}

}
