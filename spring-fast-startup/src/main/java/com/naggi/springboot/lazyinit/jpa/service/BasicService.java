package com.naggi.springboot.lazyinit.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.inittest.data.Greeting;
import com.naggi.springboot.lazyinit.jpa.data.Job;

@Service
public class BasicService {

	private static final Logger log = LoggerFactory.getLogger(BasicService.class);

	@PersistenceContext
	private EntityManager em;

	public BasicService() {
		log.info("heavy service constracter has been called.");
	}

	public List<Job> generalRetrieveData() {
		TypedQuery<Job> query = em.createQuery("SELECT p FROM Job p", Job.class);
		List<Job> results = query.getResultList();

		return results;
	}

}
