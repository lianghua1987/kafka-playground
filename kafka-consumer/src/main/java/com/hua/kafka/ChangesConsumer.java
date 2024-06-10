package com.hua.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChangesConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(ChangesConsumer.class);

    @KafkaListener(topics = "hua_kafka_topic", groupId = "hua-kafka-group")
    public void consume1(ConsumerRecord<String, String> consumerRecord) {
        LOGGER.info(String.format("Consumer1 -> key: %s, value: %s, offset: %s, partition: %s", consumerRecord.key(), consumerRecord.value(), consumerRecord.offset(), consumerRecord.partition()));
    }

    @KafkaListener(topics = "hua_kafka_topic", groupId = "hua-kafka-group")
    public void consume2(ConsumerRecord<String, String> consumerRecord) {
        LOGGER.info(String.format("Consumer2 -> key: %s, value: %s, offset: %s, partition: %s", consumerRecord.key(), consumerRecord.value(), consumerRecord.offset(), consumerRecord.partition()));
    }

}
