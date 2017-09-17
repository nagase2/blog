package com.naggi.springboot.lazyinit.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class BeanConfig {
	
	@Bean
	@Lazy
	public Greeting greetingBean(){
		System.out.println("greeting bean loaded.");
		return new Greeting();
	}
}

