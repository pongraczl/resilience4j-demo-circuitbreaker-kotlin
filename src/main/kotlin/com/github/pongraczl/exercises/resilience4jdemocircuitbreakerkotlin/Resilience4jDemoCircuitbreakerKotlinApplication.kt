package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Resilience4jDemoCircuitbreakerKotlinApplication

fun main(args: Array<String>) {
    runApplication<Resilience4jDemoCircuitbreakerKotlinApplication>(*args)
}
