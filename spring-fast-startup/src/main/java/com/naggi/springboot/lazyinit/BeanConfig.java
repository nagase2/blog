package com.naggi.springboot.lazyinit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.naggi.springboot.lazyinit.data.Greeting;

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
