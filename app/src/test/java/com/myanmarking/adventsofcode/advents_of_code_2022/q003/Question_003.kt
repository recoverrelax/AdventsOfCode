package com.myanmarking.adventsofcode.advents_of_code_2022.q003

import com.myanmarking.adventsofcode.advents_of_code_2022.q002.RuckSack
import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

@Suppress("ConvertArgumentToSet")
class Question_003 : AdventsOfCodeIntTest() {

    private fun buildContentList(input: String): List<RuckSack> {
        return input.lines()
            .map { line: String ->
                line.chunked(line.length / 2)
                    .map { it.toList() }
                    .let { RuckSack(it.component1(), it.component2()) }
            }
    }

    override fun answer1(input: String): Int {
        return buildContentList(input)
            .map(RuckSack::findFirstIntercept)
            .sumOf { it.score() }
    }

    override fun answer2(input: String): Int {
        return buildContentList(input)
            .chunked(3)
            .map { group: List<RuckSack> ->
                val (cp1, cp2, cp3) = group

                val result = cp1.all.intersect(cp2.all)
                val result2 = cp2.all.intersect(cp3.all)

                result.intersect(result2).toList().first()
            }.sumOf { it.score() }
    }
}