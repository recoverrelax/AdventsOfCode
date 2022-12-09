package com.myanmarking.adventsofcode.advents_of_code_2022.q002

import java.lang.UnsupportedOperationException

enum class Result(val score: Int) {
    WIN(6) {
        override fun getCardForResult(card: Card) = when (card) {
            Card.ROCK -> Card.PAPER
            Card.PAPER -> Card.SCISSORS
            Card.SCISSORS -> Card.ROCK
        }
    },
    LOSE(0) {
        override fun getCardForResult(card: Card) = when (card) {
            Card.ROCK -> Card.SCISSORS
            Card.PAPER -> Card.ROCK
            Card.SCISSORS -> Card.PAPER
        }
    },
    DRAW(3) {
        override fun getCardForResult(card: Card) = card
    };

    abstract fun getCardForResult(card: Card): Card

    companion object {
        fun from(input: String) = when (input) {
            "X" -> LOSE
            "Y" -> DRAW
            "Z" -> WIN
            else -> throw UnsupportedOperationException()
        }
    }
}