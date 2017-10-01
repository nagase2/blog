package com.naggi.springboot.lazyinit.jpa.data;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BasicModel {
	private Todo todo;
	String value1;
	String value2;
	String value3;
	
	
	

}
