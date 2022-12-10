package com.myanmarking.adventsofcode.advents_of_code_2022.q005

import java.util.*

data class ShipSupplies(
    val stacks: List<LinkedList<Char>>
) {
    private fun getStackFromIndex(index: Int) = stacks[index]

    fun move(amount: Int, from: Int, to: Int) {
        repeat(amount){
            val move = getStackFromIndex(from - 1)
                .pop()

            getStackFromIndex(to - 1)
                .push(move)
        }
    }

    fun groupMove(amount: Int, from: Int, to: Int) {
        buildList {
            repeat(amount){
                add(
                    getStackFromIndex(from - 1)
                        .pop()
                )
            }
        }
            .reversed()
            .onEach {
                getStackFromIndex(to - 1)
                    .push(it)
            }

    }
}