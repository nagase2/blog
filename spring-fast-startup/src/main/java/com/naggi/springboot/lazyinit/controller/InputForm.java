package com.naggi.springboot.lazyinit.controller;

import javax.annotation.CheckForNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class InputForm {
	@NotNull
	String value1;
	
	@Max(10)
	int num1;
	


	

}
