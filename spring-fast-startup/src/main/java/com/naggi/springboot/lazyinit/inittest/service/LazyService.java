package com.naggi.springboot.lazyinit.inittest.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.inittest.data.Greeting;

@Service
//@Lazy(false)
public class LazyService {

	private static final Logger log = LoggerFactory.getLogger(LazyService.class);
	
	@PersistenceContext
	private EntityManager em;
	
	Greeting gree;

	public LazyService() {
		log.info("lazy service constracter has been called.");

	}

	public String sayHello(String clientName) {

		return "good evening!!! " + clientName;
	}

}
