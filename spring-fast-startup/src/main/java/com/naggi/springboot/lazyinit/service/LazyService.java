package com.naggi.springboot.lazyinit.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.data.Greeting;
import com.naggi.springboot.lazyinit.data.User;
import com.naggi.springboot.lazyinit.repository.UserRepository;

@Service
//@Lazy(false)
public class LazyService {

	private static final Logger log = LoggerFactory.getLogger(LazyService.class);
	

	Greeting gree;

	public LazyService() {
		log.info("lazy service constracter has been called.");
		try {
			final int LOOP_MAX = 2;
			for(int i=0;i<=LOOP_MAX;i++){
				Thread.sleep(1_000);
				log.info("wait until"+ (LOOP_MAX-i) +"seconds");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("lazy service constracter ended.");
	}

	public String sayHello(String clientName) {

		return "good evening!!! " + clientName;
	}

}
