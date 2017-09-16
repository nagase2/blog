package com.naggi.springboot.lazyinit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	private static final Logger log = LoggerFactory.getLogger(HelloService.class);
	
	public HelloService() {
		log.info("hello service constracter has been called.");
		try {
			Thread.sleep(3_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String sayHello(String clientName){
		log.info("say hellow method has been called.");
		return "hello!!! "+ clientName;
	}


}
