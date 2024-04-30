package com.example.restkafka.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QueueService {
    
    private final KafkaTemplate<Object, Object> template;

    public <T> void addToQueue(String topic, T message) {
        template.send(topic, message);
    }
}
