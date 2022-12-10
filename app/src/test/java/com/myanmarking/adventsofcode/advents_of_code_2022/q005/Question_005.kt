package com.myanmarking.adventsofcode.advents_of_code_2022.q005

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest
import java.util.LinkedList
import java.util.Stack

class Question_005 : AdventsOfCodeIntTest() {

    private fun buildExpeditionPlan(input: String): ExpeditionPlan {
        val map = hashMapOf<Int, LinkedList<Char>>()
        val part1 = input.substring(0, input.indexOfLast { it == ']' } + 1)
        val part2 = input.substring(input.indexOf("move"), input.length)

        for (element in part1.lines()) {
            element.toCharArray().forEachIndexed { index, char ->
                if (char.isLetter()) {
                    val stack = map[index] ?: LinkedList<Char>()
                    stack.add(char)
                    map[index] = stack
                }
            }
        }

        return ExpeditionPlan(
            supplies = ShipSupplies(
                stacks = map.toSortedMap().values.toList()
            ),
            commands = part2.lines()
                .map { element: String ->
                    Command(
                        amount = element.substring(
                            startIndex = element.indexOfFirst { it.isDigit() },
                            endIndex = element.indexOf(" from")
                        ).toInt(),
                        from = element.substring(
                            startIndex = element.indexOf("from") + 5,
                            endIndex = element.indexOf("to") - 1
                        ).toInt(),
                        to = element.substring(
                            startIndex = element.indexOf("to") + 3,
                            endIndex = element.lastIndex + 1
                        ).toInt(),
                    )
                }
        )
    }

    override fun answer1(input: String): Any {
        val plan = buildExpeditionPlan(input)
        plan.execute(MoveType.SINGLE)
        return plan.supplies.stacks.map { it.first() }.joinToString("")
    }

    override fun answer2(input: String): Any {
        val plan = buildExpeditionPlan(input)
        plan.execute(MoveType.GROUP)
        return plan.supplies.stacks.map { it.first() }.joinToString("")
    }
}