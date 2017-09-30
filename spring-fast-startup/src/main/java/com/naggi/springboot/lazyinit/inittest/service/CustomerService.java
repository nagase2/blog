package com.naggi.springboot.lazyinit.inittest.service;

import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naggi.springboot.lazyinit.inittest.data.Customer;
import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.inittest.repository.CustomerRepository;

/**
 * カスタマのサービスクラス
 * 
 * @author nagase
 *
 */
@Service
// サービスクラスであることを示す。Componentと意味は変わらない
@lombok.extern.slf4j.Slf4j
@Transactional
public class CustomerService {

	//private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository customerRepository;
	public CustomerService() {
		log.warn("customer service constracter called, this class will be loaded eagaly all the time./");
	}
	
	/*
	 * すべてを返す
	 */
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	/*
	 * すべてを返す(限定版）
	 */
	// @Secured("authenticated")
	public List<Customer> findAllSecured() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("★" + authentication);

		return customerRepository.findAll();
	}

	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAllOrderByName2(pageable);
	}

	public Customer findOne(Integer id) {
		return customerRepository.findOne(id);
	}

	/**
	 * ログインありの場合
	 * 
	 * @param customer
	 * @param user
	 * @return
	 */
	public Customer create(Customer customer, User user) {
		System.out.println("ccc5555cc");
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	/**
	 * ログイン無しの場合
	 * 
	 * @param customer
	 * @param user
	 * @return
	 */
	public Customer create(Customer customer) {
		System.out.println("ログインなし");
		return customerRepository.save(customer);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(Integer id) {
		customerRepository.delete(id);
	}

	public Customer update(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}

}
