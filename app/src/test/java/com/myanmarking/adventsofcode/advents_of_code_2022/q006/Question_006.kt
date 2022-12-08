package com.myanmarking.adventsofcode.advents_of_code_2022.q006

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

class Question_006: AdventsOfCodeIntTest() {
    private fun solve(input: String, chartCount: Int): Int {
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

    override fun answer1(input: String) = solve(input, 4)
    override fun answer2(input: String) = solve(input, 14)
}