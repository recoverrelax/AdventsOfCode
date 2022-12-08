package com.myanmarking.adventsofcode.utils

import org.junit.Test

interface BaseTest<T> {
    val question: String
    val input: String

    val answer1: T

    open val answer2: T
        get() = TODO()

    open val answer3: T
        get() = TODO()

    open val answer4: T
        get() = TODO()

    @Test
    fun test()
}