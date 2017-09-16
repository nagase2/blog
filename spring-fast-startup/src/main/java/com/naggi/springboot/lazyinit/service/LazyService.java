package com.naggi.springboot.lazyinit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.data.Greeting;

@Service
@Lazy
public class LazyService {

	private static final Logger log = LoggerFactory.getLogger(LazyService.class);
	
	
	Greeting gree;

	public LazyService() {
		log.info("lazy service constracter has been called.");
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("lazy service constracter end here.");

	}

	public String sayHello(String clientName) {

		return "good evening!!! " + clientName;
	}

}
