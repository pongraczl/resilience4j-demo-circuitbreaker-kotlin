package com.github.pongraczl.exercises.resilience4jdemocircuitbreakerkotlin;

interface GeneralService {

    fun getResult(): String = "Result of ${this.javaClass.simpleName}"

}
