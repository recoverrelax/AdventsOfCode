package com.myanmarking.adventsofcode.advents_of_code_2022.q008

inline fun <T> Iterable<T>.takeWhileInclusive(predicate: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()
    for (item in this) {
        if (!predicate(item)) {
            list.add(item)
            break
        }
        list.add(item)
    }
    return list
}