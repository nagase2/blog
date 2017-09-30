package com.naggi.springboot.lazyinit.jpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naggi.springboot.lazyinit.inittest.data.Customer;
import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.inittest.service.CustomerService;
import com.naggi.springboot.lazyinit.inittest.service.LazyUserService;
import com.naggi.springboot.lazyinit.jpa.data.Job;
import com.naggi.springboot.lazyinit.jpa.service.BasicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/basic")
@Slf4j
public class BasicController {
	private static final Logger log = LoggerFactory.getLogger(BasicController.class);
	
	@Autowired
	BasicService basicService;
	
	public BasicController(){
		log.warn("★user controller has been called.");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Job> basicDataRetrieve(Model model /* 画面に値を渡すために、Modelオブジェクトを使用する */) {
		log.info("xxxxx");
		List<Job> jobs = basicService.generalRetrieveData();
		return jobs; 
	}
	
//	@RequestMapping(value="/check",method = RequestMethod.GET)
//	InputForm check(@Validated InputForm inform) {
//		
//		log.info(inform.toString());
//		return inform;
//	}
	
}

