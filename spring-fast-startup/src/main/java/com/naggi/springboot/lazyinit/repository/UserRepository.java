package com.naggi.springboot.lazyinit.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.naggi.springboot.lazyinit.data.User;

@Component
@Lazy
@Order(311)
public interface UserRepository extends JpaRepository<User, String>,UserRepositoryCustom{


}
