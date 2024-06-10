package com.hua.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChangesConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(ChangesConsumer.class);

    @KafkaListener(topics = "hua_kafka_topic", groupId = "hua-kafka-group")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage));
    }

}
