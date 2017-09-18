package com.naggi.springboot.lazyinit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naggi.springboot.lazyinit.data.User;

public interface UserRepository extends JpaRepository<User, String> {


}
