package com.myanmarking.adventsofcode.advents_of_code_2022.q004

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

class Question_004: AdventsOfCodeIntTest(){

    private fun buildAssignments(input: String): List<AssignmentPair>{
        return input.lines()
            .map { line ->
                val (ass1, ass2) = line.split(",")

                val (ass1_p1, ass1_p2) = ass1.split("-")
                val (ass2_p1, ass2_p2) = ass2.split("-")

                AssignmentPair(
                    elf1 = IntRange(ass1_p1.toInt(), ass1_p2.toInt()),
                    elf2 = IntRange(ass2_p1.toInt(), ass2_p2.toInt())
                )
            }
    }

    override fun answer1(input: String): Any {
        return buildAssignments(input)
            .map { it.isFullyIntercepted() }
            .count { it }
    }

    override fun answer2(input: String): Any {
        return buildAssignments(input)
            .map { it.isIntercepted() }
            .count { it }
    }
}