package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.ManagedBean;

@SpringBootApplication
@MapperScan("com.example.demo.student.dal")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("注入的Bean: ");
            String[] beanNames = ctx.getBeanDefinitionNames();
            for (String beanName : beanNames) {
                if (beanName.contains("student")) {
                    System.out.println(beanName);
                }
            }
        };
    }
}
