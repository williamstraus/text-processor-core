package com.wordprocessor.core;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    private String uuid;

    public String send(String input) {
        this.template.convertAndSend(queue.getName(), generateId() + input);
        return uuid;
    }

    private String generateId() {
        uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
