package com.myanmarking.adventsofcode.advents_of_code_2022.q004

data class AssignmentPair(
    val elf1: IntRange,
    val elf2: IntRange
) {
    fun isFullyIntercepted(): Boolean {
        val intersection = elf1.intersect(elf2)
        return intersection == elf1.toSet() || intersection == elf2.toSet()
    }

    fun isIntercepted(): Boolean {
        return elf1.intersect(elf2).isNotEmpty()
    }
}