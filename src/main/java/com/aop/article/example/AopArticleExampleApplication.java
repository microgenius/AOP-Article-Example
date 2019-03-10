package com.aop.article.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.aop.article.example.service"
})
public class AopArticleExampleApplication {
  public static void main(String[] args) {
    SpringApplication.run(AopArticleExampleApplication.class, args);
  }
}
