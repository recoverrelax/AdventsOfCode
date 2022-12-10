package com.myanmarking.adventsofcode.utils

import org.junit.Test

abstract class AdventsOfCodeIntTest(){
    private val fileName: String = "input_" + this::class.java.simpleName.replace("Question_", "")

    private val input: String =
        checkNotNull(this.javaClass.classLoader).getResourceAsStream("${fileName}.txt")
            .bufferedReader().use { it.readText() }.trimIndent()

    abstract fun answer1(input: String): Any
    abstract fun answer2(input: String): Any

    @Test
    fun answers(){
        print("""
            
            Test: ${this::class.java.simpleName.replace("Question_", "")}
                Answer1 is: ${answer1(input)}
                Answer2 is: ${answer2(input)}
                
        """.trimIndent())
    }
}