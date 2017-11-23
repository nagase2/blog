package com.naggi.springboot.lazyinit.service.heavyservice;

import javax.persistence.Entity;

import org.jfree.util.Log;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Slf4j
public class HeavyLoadBean {
	public HeavyLoadBean(String id, int count) {
		int waitSec = 500;
		Log.info("WAIT for " + waitSec + "sec...for "+id);
		System.out.println("WAIT for " + waitSec + "sec...for "+id);
		try {
			Thread.sleep(waitSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.id = id;
		this.count = count;
	}
	
	String id;
	int count;

}
