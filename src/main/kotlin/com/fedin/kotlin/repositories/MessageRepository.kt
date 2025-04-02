package com.fedin.kotlin.repositories

import com.fedin.kotlin.data_classes.Message
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MessageRepository : CrudRepository<Message, String> {
}