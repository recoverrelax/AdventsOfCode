package com.myanmarking.adventsofcode.advents_of_code_2022.q001

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

class Question_001 : AdventsOfCodeIntTest() {
    private fun buildGroups(input: String): List<List<Int>> {
        val groups = mutableListOf<List<Int>>()
        val stepGroup = mutableListOf<Int>()

        for (line in input.lines()) {
            if (line.isNotEmpty()) {
                stepGroup.add(line.toInt())
            } else {
                groups.add(stepGroup.toList())
                stepGroup.clear()
            }
        }
        return groups
    }

    override fun answer1(input: String): Int {
        return buildGroups(input)
            .maxOf { it.sum() }
    }

    override fun answer2(input: String): Int {
        return buildGroups(input).map { it.sum() }
            .sorted()
            .takeLast(3)
            .sum()
    }
}