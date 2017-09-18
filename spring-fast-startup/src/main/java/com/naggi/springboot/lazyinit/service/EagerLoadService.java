package com.naggi.springboot.lazyinit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class EagerLoadService {
	
	private static final Logger log = LoggerFactory.getLogger(EagerLoadService.class);
	
	public EagerLoadService() {
		log.warn("hello service constracter called, this class will be loaded eagaly all the time.");
		try {
			Thread.sleep(2_000);
			final int LOOP_MAX = 3;
			for(int i=0;i<=LOOP_MAX;i++){
				Thread.sleep(1_000);
				log.info("wait until"+ (LOOP_MAX-i) +"seconds");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String sayHello(String clientName){
		log.info("say hello method has been called.");
		return "hello!!!!!!!"+ clientName;
		
	}
}
