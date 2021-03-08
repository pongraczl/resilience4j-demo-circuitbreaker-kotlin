package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.client

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

const val PATH_MANY = "/ManyFailing2in3ResponseClientController"
const val PATH_ONE = "/Failing2in3ResponseClientController"

@RestController
class FailingResponseClientController(
        val clientServiceB: ClientServiceB,
        val clientServiceC: ClientServiceC
) {

    @GetMapping(PATH_MANY)
    fun get(): String = clientServiceC.getResult()

    @GetMapping(PATH_ONE)
    fun getOne(): String = clientServiceB.getResult()

}
