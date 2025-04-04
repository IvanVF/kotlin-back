package com.fedin.kotlin.services

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RabbitMessageProducer(private val template: RabbitTemplate) {

    @Value("\${rabbitmq.queue.name}")
    private val messageQueue: String? = null

    @Value("\${rabbitmq.queue_with_delay.name}")
    private val messageWithDelayQueue: String? = null

    fun sendMessage(message: String) {
        if (messageQueue != null) {
            template.convertAndSend(messageQueue, message)
        }
    }

    fun sendMessageToQueueWithDelay(message: String) {
        if (messageWithDelayQueue != null) {
            template.convertAndSend(messageWithDelayQueue, message)
        }
    }

}