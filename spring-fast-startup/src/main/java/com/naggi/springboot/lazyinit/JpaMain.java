package com.naggi.springboot.lazyinit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.ComponentScan;

import com.naggi.springboot.lazyinit.inittest.data.Customer;
import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.jpa.data.Todo;


@ComponentScan(basePackageClasses = LazyApplication.class)
public class JpaMain {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    @PersistenceContext
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
    	Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addPackage("com.naggi.springboot.lazyinit");
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Todo.class);
		
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
        List<Todo> todoList = q.getResultList();
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        em.persist(todo);
        em.getTransaction().commit();

        em.close();
    }
}
