package com.kafkaSpringBoot.controller

import com.kafkaSpringBoot.controller.request.MessageRequest
import com.kafkaSpringBoot.service.MessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/message")
class MessageController(
    private val messageService: MessageService
) {
    @PostMapping
    fun publish(@RequestBody messageRequest: MessageRequest) {
        messageService.publish(messageRequest)
    }
}