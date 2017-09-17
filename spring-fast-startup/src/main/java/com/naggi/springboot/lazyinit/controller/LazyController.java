package com.naggi.springboot.lazyinit.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naggi.springboot.lazyinit.data.Greeting;
import com.naggi.springboot.lazyinit.service.HelloService;
import com.naggi.springboot.lazyinit.service.LazyService;
import com.naggi.springboot.lazyinit.service.heavyservice.HeavyService;

@RestController
public class LazyController {

	
	@Autowired
	private LazyService lazyService;
	@Autowired
	private HeavyService heavyService;
	@Autowired
	private Greeting gree;
	
	private static final Logger log = LoggerFactory.getLogger(LazyController.class);

  
    @RequestMapping("/lazy")
    public String callLazy(){
    	gree.setId(123);
    	log.info("lazy function has been called." + gree.getContent());
    	return lazyService.sayHello("yoshi");
    }
    
}