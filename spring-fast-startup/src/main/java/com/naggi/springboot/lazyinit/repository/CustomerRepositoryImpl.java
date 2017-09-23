package com.naggi.springboot.lazyinit.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;

import com.naggi.springboot.lazyinit.controller.GreetingRestController;


public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryImpl.class);
	
		public CustomerRepositoryImpl() {
			log.info("★content repository constracter called.");
			try {
				final int LOOP_MAX = 1;
				for(int i=0;i<=LOOP_MAX;i++){
					Thread.sleep(1_000);
					log.warn("wait until"+ (LOOP_MAX-i) +"seconds");
				}
			} catch (InterruptedException e) {
		}

	}

}
