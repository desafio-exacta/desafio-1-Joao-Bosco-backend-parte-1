package com.exactaworks.desafio.service

import com.exactaworks.desafio.dto.Gasto
import com.exactaworks.desafio.repository.GastoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GastoService(
    private val gastoRepository: GastoRepository
) {

    fun create(gasto: Gasto) {
        gastoRepository.save(gasto)
    }

    fun findAll(): MutableIterable<Gasto> {
        return gastoRepository.findAll()
    }

    fun find(id: Long): Gasto? {
        return gastoRepository.findByIdOrNull(id)
    }

    fun remove(id: Long): Boolean {
        val gasto = gastoRepository.findByIdOrNull(id)
        return if (gasto != null) {
            gastoRepository.deleteById(id)
            true
        } else {
            false
        }
    }

    fun update(gasto: Gasto): Boolean {
        val aux = gastoRepository.findByIdOrNull(gasto.id)
        return if (aux != null) {
            gastoRepository.save(gasto)
            true
        } else {
            false
        }
    }
}