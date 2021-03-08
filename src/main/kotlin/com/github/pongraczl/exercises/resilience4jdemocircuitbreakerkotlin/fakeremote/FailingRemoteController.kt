package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.fakeremote

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

const val FAILING_REMOTE_CONTROLLER_PATH: String = "/Failing2in3RemoteController"

@RestController
class FailingRemoteController(
        private val randomFailingRemoteServiceA: FailingRemoteServiceA
) {

    @GetMapping(FAILING_REMOTE_CONTROLLER_PATH)
    fun getResult(): String {
        try {
            return randomFailingRemoteServiceA.twoOfThreeIsFailure()
        } catch (e: RuntimeException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "FAILED")
        }
    }
}
