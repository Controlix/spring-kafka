package spring.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Value("${kafka.topic.boot}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload, int count) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        for (int i=0; i<count; i++)
            kafkaTemplate.send(topic, payload);
    }
}
