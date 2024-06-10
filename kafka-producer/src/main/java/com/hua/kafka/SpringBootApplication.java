package com.hua.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@EnableAutoConfiguration
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class);
    }

    @Autowired
    private ChangesProducer producer;

    @Autowired
    KafkaTemplate<String, String> template;

    @Override
    public void run(String... args) throws Exception {
//        SendResult<String, String> send1 = template.send("hua_kafka_topic", "item1", "key1").get();
//        SendResult<String, String> send2 = template.send("hua_kafka_topic", "item2", "key2").get();
//        SendResult<String, String> send3 = template.send("hua_kafka_topic", "item3", "key3").get();
//        if (send1.getRecordMetadata() != null) {
//            System.out.println("Event message sent to " + send1.getProducerRecord().topic() + " with value: " + send1.getProducerRecord().value() + " successfully!");
//        }
//
//        if (send1.getRecordMetadata() != null) {
//            System.out.println("Event message sent to " + send2.getProducerRecord().topic() + " with value: " + send2.getProducerRecord().value() + " successfully!");
//        }
//
//        if (send1.getRecordMetadata() != null) {
//            System.out.println("Event message sent to " + send3.getProducerRecord().topic() + " with value: " + send3.getProducerRecord().value() + " successfully!");
//        }

        for (int i = 0; i < 1_000_000; i++) {
            template.send("hua_kafka_topic", "key" + i, "value" + i);
        }

//        producer.sendMessage();

    }
}
