package com.kafkaSpringBoot

import org.springframework.boot.CommandLineRunner
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Runner(private val kafkaTemplate: KafkaTemplate<String, String>) : CommandLineRunner {
    override fun run(vararg args: String?) {
        var i = 0
        while (i <= 100) {
            val send = kafkaTemplate.send("amigosCode", "hello world kafka :)")
            println("-------------------$send")
            i++
        }
    }
}