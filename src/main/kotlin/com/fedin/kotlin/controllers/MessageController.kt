package com.fedin.kotlin.controllers

import com.fedin.kotlin.data_classes.Message
import com.fedin.kotlin.services.MessageService
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
class MessageController(private val messageService: MessageService) {

    @GetMapping("/")
    fun index() = messageService.findMessages()

    @PostMapping
    fun postMessage(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = messageService.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Message? {
        return messageService.findMessageById(id)
    }
}