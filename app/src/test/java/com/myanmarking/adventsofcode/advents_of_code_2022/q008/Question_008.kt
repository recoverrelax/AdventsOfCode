package com.myanmarking.adventsofcode.advents_of_code_2022.q008

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

class Question_008 : AdventsOfCodeIntTest() {

    override fun answer1(input: String): Int {
        fun Boolean.toInt() = if(this) 1 else 0

        val grid = ElvenTreeGrid(input.lines())

        return grid.sumOf { element: ElementInfo ->
            val up = element.getDirectionElements(Direction.UP)
                .all { it < element.element }
            val down = element.getDirectionElements(Direction.DOWN)
                .all { it < element.element }
            val left = element.getDirectionElements(Direction.RIGHT)
                .all { it < element.element }
            val right = element.getDirectionElements(Direction.LEFT)
                .all { it < element.element }

            (up || down || left || right).toInt()
        }
    }

    override fun answer2(input: String): Int {
        val grid = ElvenTreeGrid(input.lines())

        return grid.maxOf { element: ElementInfo ->
            val up = element.getDirectionElements(Direction.UP)
                .asReversed()
                .takeWhileInclusive { it < element.element }
                .count()

            val down = element.getDirectionElements(Direction.DOWN)
                .takeWhileInclusive { it < element.element }
                .count()

            val left = element.getDirectionElements(Direction.LEFT)
                .asReversed()
                .takeWhileInclusive { it < element.element }
                .count()

            val right = element.getDirectionElements(Direction.RIGHT)
                .takeWhileInclusive { it < element.element }
                .count()

            up * down * left * right
        }
    }
}