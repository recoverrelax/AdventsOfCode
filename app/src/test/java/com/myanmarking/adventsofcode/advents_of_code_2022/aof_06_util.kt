package com.myanmarking.adventsofcode.advents_of_code_2022

sealed class Node {
    class Directory(
        val name: String,
        val parent: Directory?,
        val child: MutableList<Node> = mutableListOf()
    ) : Node() {
        val totalSize: Int
            get() = child.sumOf { element: Node ->
                when (element) {
                    is Directory -> element.totalSize
                    is File -> element.size
                }
            }

        override fun toString(): String {
            return "Directory:(name='$name', child=$child, totalSize: $totalSize)"
        }
    }

    class File(
        val name: String,
        val size: Int
    ) : Node() {
        override fun toString(): String {
            return "File(name='$name', size=$size)"
        }
    }
}