package com.naggi.springboot.lazyinit.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.naggi.springboot.lazyinit.inittest.data.Greeting;
import com.naggi.springboot.lazyinit.jpa.data.BasicModel;
import com.naggi.springboot.lazyinit.jpa.data.Job;
import com.naggi.springboot.lazyinit.jpa.data.Todo;

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
	
	/**
	 * Todoの一覧を表示する。Todoの一覧の中には、すでに存在しないユーザのIDもある。
	 * ①ユーザが存在しない場合、そのTodoは表示しない（InnterJoin)
	 * ②ユーザが存在しなくても、一覧に表示する（LeftJoin)
	 */
	public List<Todo> retrieveTodos1() {
		TypedQuery<Todo> query = em.createQuery("SELECT t FROM Todo t LEFT OUTER JOIN t.owner o", Todo.class);
		List<Todo> results = query.getResultList();
		return results;
	}
	/**
	 * SQLでデータを取得してエンティティに入れて返す。
	 * @return
	 */
	public List<BasicModel> retrieveTodos2() {
		Query query = em.createNativeQuery("SELECT j.id as value1,j.job_descr FROM job as j ");
		@SuppressWarnings("unchecked")
		List<BasicModel> results = query.getResultList();
		return results;
	}
	/**
	 * 生SQLを実行して、Modelに入れる
	 * 生SQLを実行して、Entityに入れる
	 * 
	 */

}
