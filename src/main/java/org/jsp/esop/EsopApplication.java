package org.jsp.esop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.jsp")

public class EsopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsopApplication.class, args);
    }
}
