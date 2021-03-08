package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

import com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.GeneralService
import com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.fakeremote.FAILING_REMOTE_CONTROLLER_PATH
import io.github.resilience4j.circuitbreaker.CallNotPermittedException
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker

@Service
class ClientServiceB(
        @Value("\${server.port}") private val serverPort: String
) : GeneralService {

    @CircuitBreaker(name = "serviceB", fallbackMethod = "fallBackOnFail")
    override fun getResult(): String {
        val restTemplate = RestTemplate()
        val remoteResult: String? = restTemplate.getForObject(getRemoteServicePath(), String::class.java)
        val ownResult: String = super<GeneralService>.getResult()
        return "$ownResult: $remoteResult"
    }

    private fun getRemoteServicePath(): String = "http://localhost:$serverPort${FAILING_REMOTE_CONTROLLER_PATH}"

    @SuppressWarnings("unused")
    private fun fallBackOnFail(e: CallNotPermittedException): String = "(Circuit breaker is open)"

    @SuppressWarnings("unused")
    private fun fallBackOnFail(e: Exception): String = "(No valid response)"

}
