package com.exactaworks.desafio.repository

import com.exactaworks.desafio.dto.Gasto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GastoRepository: CrudRepository<Gasto,Long> {
}