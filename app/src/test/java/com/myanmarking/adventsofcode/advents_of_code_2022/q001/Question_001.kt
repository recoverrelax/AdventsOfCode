package com.myanmarking.adventsofcode.advents_of_code_2022.q001

import com.myanmarking.adventsofcode.utils.readFile
import org.junit.Test

class Question_001 {
    private val input: String = this.javaClass.readFile("input_01")

    @Test
    fun test() {
        print(this)
        val groups = mutableListOf<List<Int>>()
        val stepGroup = mutableListOf<Int>()

        for (line in input.lines()) {
            if(line.isNotEmpty()){
                stepGroup.add(line.toInt())
            } else{
                groups.add(stepGroup.toList())
                stepGroup.clear()
            }
        }
        println(
            "Answer1: " + groups.maxOfOrNull { it.sum() }
        )

        println(
            "Answer2: " + groups.map { it.sum() }
                .sorted()
                .takeLast(3)
                .sum()
        )
    }
}