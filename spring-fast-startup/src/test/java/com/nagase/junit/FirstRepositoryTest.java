package com.nagase.junit;

import static org.junit.Assert.*;

import org.junit.Test;





import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.inittest.repository.UserRepository;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FirstRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testExample() throws Exception {
        this.entityManager.persist(new User("sboot", 0, "1234"));
        User user = this.repository.findOne("nagase");
        assertThat(user.getUsername()).isEqualTo("sboot");
        assertThat(user.getAge()).isEqualTo("89");
    }

}