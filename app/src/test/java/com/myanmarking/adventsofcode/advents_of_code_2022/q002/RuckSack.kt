package com.myanmarking.adventsofcode.advents_of_code_2022.q002

data class RuckSack(
    val cp1: List<Char>,
    val cp2: List<Char>,
){
    val all: List<Char> = cp1 + cp2

    fun findFirstIntercept(): Char = cp1.intersect(cp2.toSet()).first()
}