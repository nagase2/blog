package com.naggi.springboot.lazyinit.inittest.controller;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naggi.springboot.lazyinit.inittest.data.Greeting;
import com.naggi.springboot.lazyinit.inittest.service.EagerLoadService;
import com.naggi.springboot.lazyinit.inittest.service.LazyService;
import com.naggi.springboot.lazyinit.jpa.service.BasicService;

@Controller
public class IndexController {

	
	@Autowired
	private LazyService lazyService;
	@Autowired
	private Greeting gree;
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

  
    @RequestMapping("/start")
    public String showIndex(){
    	gree.setId(123);
    	log.info("lazy function has been called." + gree.getContent());
    	return "index";
    }
    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        log.info("/!");
        return "loginForm";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}