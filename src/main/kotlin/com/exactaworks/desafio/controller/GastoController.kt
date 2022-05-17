package com.exactaworks.desafio.controller

import com.exactaworks.desafio.dto.Gasto
import com.exactaworks.desafio.service.GastoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/")
class GastoController(
    private val gastoService: GastoService
) {

    @PostMapping("create")
    fun createGasto(@RequestBody gasto: Gasto): HttpStatus {
        gastoService.create(gasto)
        return HttpStatus.CREATED
    }

    @GetMapping("findAll")
    fun listAllGastos(): MutableIterable<Gasto> {
        return gastoService.findAll()
    }

    @GetMapping("find/{id}")
    fun listGasto(@PathVariable id: Long): Gasto? {
        return gastoService.find(id)
    }

    @DeleteMapping("remove/{id}")
    fun removeGasto(@PathVariable id: Long): HttpStatus {
        return if (gastoService.remove(id)) {
            HttpStatus.OK
        } else {
            HttpStatus.NOT_FOUND
        }
    }

    @PutMapping("update")
    fun updateGasto(@RequestBody gasto: Gasto): HttpStatus {
        return if (gastoService.update(gasto)) {
            HttpStatus.OK
        } else {
            HttpStatus.NOT_FOUND
        }
    }
}