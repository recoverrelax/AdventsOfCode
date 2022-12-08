package com.myanmarking.adventsofcode.advents_of_code_2022.q006

import com.myanmarking.adventsofcode.utils.readFile
import org.junit.Assert
import org.junit.Test

class Question_006 {

    private val input: String = this.javaClass.readFile("input_06")

    private fun solve(chartCount: Int): Int {
        val inputChar = input.toCharArray()
        inputChar.forEachIndexed { index, _ ->
            val elements = List(chartCount) { i ->
                inputChar[index + i]
            }.toSet()
            if (elements.size == chartCount) {
                return index + chartCount
            }
        }

        return 0
    }

    @Test
    fun test() {
        Assert.assertEquals(solve(4), 1658)
        Assert.assertEquals(solve(14), 2260)
    }
}