package org.kicktipp.annotationorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync(mode = AdviceMode.ASPECTJ)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class AnnotationOrderApplication {

    static void main(String[] args) {
        SpringApplication.run(AnnotationOrderApplication.class, args);
    }

}
