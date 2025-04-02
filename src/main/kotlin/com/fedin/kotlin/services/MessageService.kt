package com.fedin.kotlin.services

import com.fedin.kotlin.data_classes.Message
import com.fedin.kotlin.repositories.MessageRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun save(message: Message): Message = db.save(message)

    fun findMessageById(id: UUID): Message? {
        return db.findByIdOrNull(id.toString())
    }
}