package com.naggi.springboot.lazyinit.inittest.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.inittest.repository.UserRepository;

@Service
public class LazyUserService {
	private static final Logger log = LoggerFactory.getLogger(LazyUserService.class);
	
	public LazyUserService(){
		log.warn("★LazyUser service constracter");
	}
	
	@Inject
	public UserRepository userRepository;
	
	public List<User> getUserAll(){
		return userRepository.findAll();
	}

}
