package com.fedin.kotlin.configs

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig {
    @Value("\${rabbitmq.queue.name}")
    private val queueName: String? = null

    @Value("\${rabbitmq.queue_with_delay.name}")
    private val queueWithDelayName: String? = null

    @Bean
    fun queue(): Queue {
        return Queue(queueName, false)
    }

    @Bean
    fun queueWithDelay(): Queue {
        return Queue(queueWithDelayName, false)
    }
}