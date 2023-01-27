package com.kafkaSpringBoot.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class KafkaListenerService {
    @KafkaListener(topics = ["amigosCode"], groupId = "foo")
    fun listener(data: String) {
        println("listener received: $data")
    }
}