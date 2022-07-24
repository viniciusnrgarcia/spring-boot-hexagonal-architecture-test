package br.com.vnrg.hexagonalarchitecture.order;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@SpringBootApplication
@EnableAsync
@EnableRabbit
public class SagaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaOrderServiceApplication.class, args);
    }

}