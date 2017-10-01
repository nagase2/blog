package com.naggi.springboot.lazyinit.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naggi.springboot.lazyinit.inittest.data.Customer;
import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.inittest.service.CustomerService;
import com.naggi.springboot.lazyinit.inittest.service.LazyUserService;
import com.naggi.springboot.lazyinit.jpa.data.BasicModel;
import com.naggi.springboot.lazyinit.jpa.data.Job;
import com.naggi.springboot.lazyinit.jpa.data.Todo;
import com.naggi.springboot.lazyinit.jpa.service.BasicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/basic")
@Slf4j
public class BasicController {
	private static final Logger log = LoggerFactory.getLogger(BasicController.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	BasicService basicService;
	
	public BasicController(){
		log.warn("★user controller has been called.");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Job> basicDataRetrieve(Model model /* 画面に値を渡すために、Modelオブジェクトを使用する */) {
		log.info("xxxxx");
		List<Job> jobs = basicService.generalRetrieveData();
		return jobs; 
	}

	@RequestMapping(method = RequestMethod.GET, value="/todo1")
	List<Todo> retrieveTodo1(Model model){
		log.info("todo一覧が呼ばれたよ");
		return basicService.retrieveTodos1();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/todo2")
	List<BasicModel> retrieveTodo2(Model model){
		log.info("todo2一覧が呼ばれたよ");
		return basicService.retrieveTodos2();
	}
	
	/**
	 * SQLでEntity上関連がない項目と関連を貼って取得する。(この例では、LEFTJOINを指定、INNERに置き換えればINNER)
	 * ができる。
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/todo3")
	List<BasicModel> retrieveTodo3(Model model){
		log.info("todo3一覧が呼ばれたよ");
		Query query = em.createNativeQuery(
				"SELECT job.id as value1,job.job_descr as value2,todo.summary as value3"
				+ " FROM job LEFT JOIN todo on job.id = todo.id"
				);
		@SuppressWarnings("unchecked")
		List<BasicModel> results = query.getResultList();
		
		return results;
	}	
	/**
	 * JPQLでEntity上関連がない項目と関連を貼って取得する。(この例では、LEFTJOINを指定、INNERに置き換えればINNER)
	 * ができる。
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/todo4")
	List<BasicModel> retrieveTodo4(Model model){
		log.info("todo4一覧が呼ばれたよ");
		Query query = em.createQuery(
				"SELECT j.id as value1,j.jobDescr as value2"
				+ " FROM Job j JOIN Todo t ON j.id = t.id"
				);
		@SuppressWarnings("unchecked")
		List<BasicModel> results = query.getResultList();
		
		return results;
	}
	
	
	

}

