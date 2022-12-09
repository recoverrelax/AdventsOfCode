package com.myanmarking.adventsofcode.advents_of_code_2022.q002

data class Play(
    val opponent: Card,
    val me: Card
) {
    private val result: Result = me.compare(opponent)
    val totalScore: Int = result.score + me.score
}