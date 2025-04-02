package com.fedin.kotlin.data_classes

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("messages")
data class Message(@Id val id: String? = null, val text: String)
