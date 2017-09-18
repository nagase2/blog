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
//@ComponentScan(basePackageClasses = {LazyApplication.class,HelloService.class,GreetingController.class},lazyInit=true)
@EnableAutoConfiguration(
//		exclude = {
//      DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class
//}
)
//@EnableTransactionManagement
//@ImportResource({ "classpath:/config/transaction-management.xml", "classpath:/config/method-invocation-trace.xml" })
//@EnableJpaAuditing(auditorAwareRef = AuditConfiguration.TTC_AUDIT_AWARE,
//      dateTimeProviderRef = AuditConfiguration.TTC_DATETIME_PROVIDER)
//@Import({ AuditConfiguration.class })
//@EnableSpringDataWebSupport
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
