package com.fedin.kotlin.controllers

import com.fedin.kotlin.data_classes.Message
import com.fedin.kotlin.services.MessageService
import com.fedin.kotlin.services.RabbitMessageProducer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
class MessageController(private val messageService: MessageService, private val rabbitMessageProducer: RabbitMessageProducer) {

    @GetMapping("/")
    fun index() = messageService.findMessages()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Message? {
        return messageService.findMessageById(id)
    }

    @PostMapping
    fun postMessage(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = messageService.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @PostMapping("/rabbit/noDelay")
    fun postRabbitMessageWithoutDelay(@RequestParam message: String) {
        rabbitMessageProducer.sendMessage(message)
    }

    @PostMapping("/rabbit/delay")
    fun postRabbitMessageWithDelay(@RequestParam message: String) {
        rabbitMessageProducer.sendMessageToQueueWithDelay(message)
    }
}