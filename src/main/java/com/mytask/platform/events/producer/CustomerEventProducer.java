
package com.mytask.platform.events.producer;

import com.mytask.platform.core.entity.CustomerProfile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "customer-profile-topic";

    public CustomerEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(CustomerProfile profile) {
        kafkaTemplate.send(TOPIC, profile.getCustomerId(), profile);
    }
}
