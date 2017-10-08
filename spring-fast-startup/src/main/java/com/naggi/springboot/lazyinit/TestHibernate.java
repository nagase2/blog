
package com.naggi.springboot.lazyinit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.ComponentScan;

import com.naggi.springboot.lazyinit.inittest.data.Customer;
import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.jpa.data.BasicModel;

@ComponentScan(basePackageClasses = LazyApplication.class)
public class TestHibernate {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addPackage("com.naggi.springboot.lazyinit");
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(User.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		factory = configuration.buildSessionFactory(serviceRegistry);
		TestHibernate testWorker = new TestHibernate();
	

		//カスタマ情報を追加する
		List<Customer> allCustomers = testWorker.getAllCustomers();



		testWorker.test1();
		
		System.out.println("終了します");
		System.exit(0);
	}

	@SuppressWarnings("unchecked")
	private List<Customer> test1() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> employees = new ArrayList();

		String str = "SELECT job.id as value1,job.job_descr as value2,todo.summary as value3"
				+ " FROM job LEFT JOIN todo on job.id = todo.id";

		try {
			tx = session.beginTransaction();
			List<BasicModel> bm = (List) session.createSQLQuery(str).list();

			tx.commit();

			for (BasicModel emp : bm) {
				System.out.print(emp.getValue1() + "  ");
				System.out.println(emp.getValue2()+ "   ");
				System.out.println(emp.getValue3()+ "   ");
				System.out.println();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return employees;

	}

	@SuppressWarnings("unchecked")
	private List<Customer> getAllCustomers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> employees = new ArrayList();
		try {
			tx = session.beginTransaction();
			employees = (List) session.createQuery("select c from Customer c ").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		for (Customer emp : employees) {
			System.out.print(emp.getFirstName() + "  ");
			if (emp.getUser() != null) {
				System.out.print(emp.getUser().getEncodedPassword() + "  ");

			}
			System.out.println();
		}

		return employees;

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<User> getAllUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List employees = new ArrayList();
		try {
			tx = session.beginTransaction();
			employees = (List) session.createQuery("select u from User u").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return employees;
	}
}