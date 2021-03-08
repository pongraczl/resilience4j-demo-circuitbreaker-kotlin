package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.client

import java.util.stream.Collectors
import java.util.stream.Stream

import org.springframework.stereotype.Service

import com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.GeneralService

const val CLIENT_SERVICE_C_REPEAT: Long = 20

@Service
class ClientServiceC(
        private val clientServiceB: ClientServiceB
) : GeneralService {

    override fun getResult(): String {
        val result: String = Stream.generate(clientServiceB::getResult)
                .limit(CLIENT_SERVICE_C_REPEAT)
                .collect(Collectors.joining("<br>"))
        return "Originally waiting for $CLIENT_SERVICE_C_REPEAT responses. ${super<GeneralService>.getResult()}:<br>$result"
    }
}
