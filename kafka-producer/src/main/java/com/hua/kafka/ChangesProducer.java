package com.hua.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class ChangesProducer {
    public static final Logger LOGGER = LoggerFactory.getLogger(ChangesProducer.class);
    private static final String topic = "hua_kafka_topic";

    @Autowired
    private ChangesHandler changesHandler;

    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendMessage() throws InterruptedException {
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(changesHandler, URI.create(url)).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}
