package com.kafkaSpringBoot.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@Configuration
class KafkaConsumerConfig {

    @Value(value = "\${spring.kafka.bootstrap-servers}")
    private lateinit var bootstrapServers: String;

    fun consumerConfig(): Map<String, Any> {
        val props = HashMap<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return props;
    }

    @Bean
    fun consumerFactory(): DefaultKafkaConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(consumerConfig())
    }

    @Bean
    fun factory(consumerFactory: DefaultKafkaConsumerFactory<String, String>): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>>{
        val concurrentKafkaListenerContainerFactory = ConcurrentKafkaListenerContainerFactory<String, String>()
        concurrentKafkaListenerContainerFactory.consumerFactory = consumerFactory
        return concurrentKafkaListenerContainerFactory
    }
}