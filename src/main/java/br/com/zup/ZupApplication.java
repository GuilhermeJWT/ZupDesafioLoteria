package br.com.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.zup.model"})
@ComponentScan(basePackages = {"br.com.zup.*"})
@EnableJpaRepositories(basePackages = {"br.com.zup.repository"})
@EnableTransactionManagement
@RestController
@EnableAutoConfiguration
public class ZupApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZupApplication.class, args);
    }

}
