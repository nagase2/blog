package com.naggi.springboot.lazyinit.service.heavyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.data.Greeting;

@Service
public class HeavyService {

	private static final Logger log = LoggerFactory.getLogger(HeavyService.class);
	
	
	Greeting gree;

	public HeavyService() {
		log.info("heavy service constracter has been called.");
		try {
			final int LOOP_MAX = 5;
			for(int i=0;i<=LOOP_MAX;i++){
				Thread.sleep(1_000);
				log.info("wait until"+ (LOOP_MAX-i) +"seconds");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public String sayHello(String clientName) {
		return "good evening!!! " + clientName;
	}

}
