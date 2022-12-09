package com.myanmarking.adventsofcode.advents_of_code_2022.q002

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest
import java.lang.UnsupportedOperationException

class Question_002 : AdventsOfCodeIntTest() {
    enum class Card(val score: Int) {
        ROCK(1),
        PAPER(2),
        SCISSORS(3)
    }

    enum class Result(val score: Int) {
        WIN(6),
        LOSE(0),
        DRAW(3)
    }

    data class Play(
        val opponent: Card,
        val me: Card
    ) {
        private val result: Result = if (me == opponent) {
            Result.DRAW
        } else {
            val win = when (me) {
                Card.ROCK -> opponent == Card.SCISSORS
                Card.PAPER -> opponent == Card.ROCK
                Card.SCISSORS -> opponent == Card.PAPER
            }
            if (win) Result.WIN else Result.LOSE
        }

        val totalScore: Int = result.score + me.score
    }

    private fun scores1(input: String): List<Int> {
        return input.lines()
            .map { line ->
                val (opponent, me) = line.split(" ")
                Play(
                    opponent = when (opponent) {
                        "A" -> Card.ROCK
                        "B" -> Card.PAPER
                        "C" -> Card.SCISSORS
                        else -> throw UnsupportedOperationException()
                    },
                    me = when (me) {
                        "X" -> Card.ROCK
                        "Y" -> Card.PAPER
                        "Z" -> Card.SCISSORS
                        else -> throw UnsupportedOperationException()
                    }
                )
            }
            .map { it.totalScore }
    }

    private fun scores2(input: String): List<Int> {
        return input.lines()
            .map { line ->
                val (opponent, me) = line.split(" ")

                val cardOpponent = when (opponent) {
                    "A" -> Card.ROCK
                    "B" -> Card.PAPER
                    "C" -> Card.SCISSORS
                    else -> throw UnsupportedOperationException()
                }

                val cardMe = when (me) {
                    "X" -> Result.LOSE
                    "Y" -> Result.DRAW
                    "Z" -> Result.WIN
                    else -> throw UnsupportedOperationException()
                }.let { result ->
                    when(result){
                        Result.WIN -> when(cardOpponent){
                            Card.ROCK -> Card.PAPER
                            Card.PAPER -> Card.SCISSORS
                            Card.SCISSORS -> Card.ROCK
                        }
                        Result.LOSE -> when(cardOpponent){
                            Card.ROCK -> Card.SCISSORS
                            Card.PAPER -> Card.ROCK
                            Card.SCISSORS -> Card.PAPER
                        }
                        Result.DRAW -> cardOpponent
                    }
                }

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