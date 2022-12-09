package com.myanmarking.adventsofcode.advents_of_code_2022.q002

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

class Question_002 : AdventsOfCodeIntTest() {
    data class Play(
        val opponent: Card,
        val me: Card
    ) {
        private val result: Result = me.compare(opponent)
        val totalScore: Int = result.score + me.score
    }

    private fun scores1(input: String): List<Int> {
        return input.lines()
            .map { line ->
                val (opponent, me) = line.split(" ")
                Play(
                    opponent = Card.from(opponent),
                    me = Card.from(me)
                )
            }
            .map { it.totalScore }
    }

    private fun scores2(input: String): List<Int> {
        return input.lines()
            .map { line ->
                val (opponent, me) = line.split(" ")

                val cardOpponent = Card.from(opponent)

                val cardMe = Result.from(me)
                    .getCardForResult(cardOpponent)

                Play(
                    opponent = cardOpponent,
                    me = cardMe
                )
            }
            .map { it.totalScore }
    }


    override fun answer1(input: String): Int = scores1(input).sum()

    override fun answer2(input: String): Int = scores2(input).sum()
}