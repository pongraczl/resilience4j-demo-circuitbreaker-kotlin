package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

    @GetMapping("/")
    fun home(): String = "Hello Resilience4j CircuitBreaker Kotlin Demo!"

}
