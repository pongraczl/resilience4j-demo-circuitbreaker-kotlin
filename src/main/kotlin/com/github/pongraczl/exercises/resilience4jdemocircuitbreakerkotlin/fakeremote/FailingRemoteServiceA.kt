package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.fakeremote

import java.util.concurrent.ThreadLocalRandom
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException

import com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin.GeneralService


@Service
class FailingRemoteServiceA : GeneralService {

    private var ofThree: Int = 0 //statefulness is not preferred, but good for solo-server example

    fun getRandomResult(): String {
        if (ThreadLocalRandom.current().nextInt(10) > 4) {
            return getResult()
        } else {
            throw RuntimeException()
        }
    }

    fun twoOfThreeIsFailure(): String {
        ofThree = (ofThree + 1) % 3
        if (ofThree % 3 == 0) {
            return getResult()
        } else {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception")
        }
    }

}
