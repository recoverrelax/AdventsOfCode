package com.myanmarking.adventsofcode.advents_of_code_2022.q003

private val chars = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',)

private val allChars = (chars + (chars.map { it.uppercaseChar() }))

private val mapping = allChars
    .mapIndexed { index, c -> c to index + 1 }
    .toMap()

fun Char.score(): Int {
    return checkNotNull(mapping[this])
}