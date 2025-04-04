package com.fedin.kotlin.services

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RabbitMessageConsumer {

    @RabbitListener(queues = ["#{@environment.getProperty('rabbitmq.queue.name')}"])
    fun receiveMessage(message: String) {
        println("*********Received message: $message **************")
    }

    @RabbitListener(queues = ["#{@environment.getProperty('rabbitmq.queue_with_delay.name')}"])
    fun receiveMessageWithDelay(message: String) {
        println("*********Received message with delay $message **************")
    }
}