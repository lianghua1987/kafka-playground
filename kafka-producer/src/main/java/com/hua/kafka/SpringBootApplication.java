package com.hua.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class);
    }

    @Autowired
    private ChangesProducer producer;

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage();

    }
}
