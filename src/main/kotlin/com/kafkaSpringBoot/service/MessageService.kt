package com.kafkaSpringBoot.service

import com.kafkaSpringBoot.controller.request.MessageRequest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(private val kafkaTemplate: KafkaTemplate<String, String>) {
    fun publish(messageRequest: MessageRequest) = kafkaTemplate.send("amigosCode", messageRequest.toString())
}
