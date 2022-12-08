package com.myanmarking.adventsofcode.utils


fun Class<*>.readFile(name: String): String {
    return this.classLoader!!.getResourceAsStream("${name}.txt")
        .bufferedReader().use { it.readText() }.trimIndent()
}