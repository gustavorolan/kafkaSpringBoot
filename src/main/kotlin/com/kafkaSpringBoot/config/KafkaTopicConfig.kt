package com.kafkaSpringBoot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {
    @Bean
    fun amigosCode() = TopicBuilder.name("amigosCode").build()
}