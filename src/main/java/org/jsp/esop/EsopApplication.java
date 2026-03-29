package org.jsp.esop;

import com.jsp.demo.AA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.jsp.demo",
                                            "org.jsp.esop"},
        excludeName = "org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration")
//@ComponentScan(basePackages = "org.jsp")

public class EsopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsopApplication.class, args);
    }
}
// hikariDataSource  automationengine