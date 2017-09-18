package com.naggi.springboot.lazyinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.naggi.springboot.lazyinit.controller.GreetingRestController;
import com.naggi.springboot.lazyinit.data.Greeting;
import com.naggi.springboot.lazyinit.service.EagerLoadService;


//@SpringBootApplication

@ComponentScan(basePackageClasses = LazyApplication.class,lazyInit=true)
//@ComponentScan(basePackageClasses = LazyApplication.class)
@EnableAutoConfiguration(
)
public class LazyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyApplication.class, args);
    }

//    @Configuration
//    @Profile("local")
//    @ComponentScan(lazyInit = true)
//    static class LocalConfig {
//    }

}
