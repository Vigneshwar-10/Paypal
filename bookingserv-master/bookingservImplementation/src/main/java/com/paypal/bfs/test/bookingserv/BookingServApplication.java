package com.paypal.bfs.test.bookingserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan("com.paypal.bfs.test.bookingserv.impl")
@EntityScan("com.paypal.bfs.test.bookingserv.api.model")
public class BookingServApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServApplication.class, args);
    }
}