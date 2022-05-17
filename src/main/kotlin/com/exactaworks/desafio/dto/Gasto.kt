package com.exactaworks.desafio.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Gasto(
    @Id
    @GeneratedValue
    val id: Long,
    val nome_pessoa: String,
    val descricao: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val data_hora: LocalDateTime,
    val valor: Double,
    val tags: String
)