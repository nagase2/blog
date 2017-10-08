package com.naggi.springboot.lazyinit;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import com.naggi.springboot.lazyinit.jpa.data.BasicModel;
import com.naggi.springboot.lazyinit.jpa.data.Family;
import com.naggi.springboot.lazyinit.jpa.data.Job;
import com.naggi.springboot.lazyinit.jpa.data.Todo;

/**
 * @author Chandan Singh
 *
 */
public class JPADemo {
	public static void main(String[] args) throws JsonProcessingException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
		EntityManager em = emf.createEntityManager();

		JPADemo self = new JPADemo();

		self.persistOneInstanceWithJPA(em);

		self.selectAllOneKindOfEntity(em);

		self.selectAllAndLeftjoin(em);

		em.close();
		System.exit(0);

	}

	/**
	 * 一つのシンプルなエンティティを永続化させるサンプル
	 * 
	 * @param em
	 * @throws JsonProcessingException
	 */
	public void persistOneInstanceWithJPA(EntityManager em) throws JsonProcessingException {

		em.getTransaction().begin();
		Family newFamily = new Family();
		newFamily.setFamId(UUID.randomUUID().toString());
		newFamily.setFamilyName("test family name");
		System.out.println("COMIITING");

		em.persist(newFamily);
		em.getTransaction().commit();

		//オブジェクトをJSON形式で出力
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(newFamily));
	}

	/**
	 * 一つのエンティティだけを検索条件なしで取得する、シンプルなサンプル
	 * 
	 * @param em
	 * @throws JsonProcessingException
	 */
	public void selectAllOneKindOfEntity(EntityManager em) throws JsonProcessingException {
		Query query = em.createQuery("SELECT j " + " FROM Job j");
		@SuppressWarnings("unchecked")
		List<Job> results = query.getResultList();

		for (Job emp : results) {
			System.out.print(emp.getJobDescr() + "  ");
			System.out.print(emp.getSalery() + "   ");

		}

	}

	/**
	 * ２つのテーブルをLeftJoinして取得するサンプル
	 * 
	 * @param em
	 */
	public void selectAllAndLeftjoin(EntityManager em) {
		TypedQuery<Todo> query = em.createQuery("SELECT t FROM Todo t LEFT OUTER JOIN fetch t.owner o", Todo.class);
		List<Todo> results = query.getResultList();

		for (Todo emp : results) {
			System.out.print(emp.getId() + "  ");
			System.out.print(emp.getDescription() + "   ");
			if (emp.getOwner() != null) {
				System.out.print(emp.getOwner());
			} else {
				System.out.print("unknown");
			}

			System.out.println();
		}
	}
}
