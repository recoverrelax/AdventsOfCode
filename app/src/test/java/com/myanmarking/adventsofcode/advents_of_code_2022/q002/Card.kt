package com.myanmarking.adventsofcode.advents_of_code_2022.q002

import java.lang.UnsupportedOperationException

enum class Card(val score: Int) {
    ROCK(1) {
        override fun compare(other: Card) = when (other) {
            ROCK -> Result.DRAW
            PAPER -> Result.LOSE
            SCISSORS -> Result.WIN
        }
    },
    PAPER(2) {
        override fun compare(other: Card) = when (other) {
            ROCK -> Result.WIN
            PAPER -> Result.DRAW
            SCISSORS -> Result.LOSE
        }
    },
    SCISSORS(3) {
        override fun compare(other: Card) = when (other) {
            ROCK -> Result.LOSE
            PAPER -> Result.WIN
            SCISSORS -> Result.DRAW
        }
    };

    abstract fun compare(other: Card): Result

    companion object {
        fun from(input: String) = when (input) {
            "A", "X" -> ROCK
            "B", "Y" -> PAPER
            "C", "Z" -> SCISSORS
            else -> throw UnsupportedOperationException()
        }
    }


}