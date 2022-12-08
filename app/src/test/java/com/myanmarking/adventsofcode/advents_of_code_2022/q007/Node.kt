package com.myanmarking.adventsofcode.advents_of_code_2022.q007

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

        fun getAllDirectories(
            directory: List<Node> = this.child
        ) = deepFlatten(directory)
        fun findDirectoryByName(name: String) = this.child
            .filterIsInstance<Directory>()
            .first { it.name == name }

        fun add(child: Node){
            this.child.add(child)
        }
    }

    data class File(
        val name: String,
        val size: Int
    ) : Node()
}

private fun deepFlatten(nodes: List<Node>): List<Node.Directory> =
    nodes
        .filterIsInstance<Node.Directory>()
        .plus(
            nodes.filterIsInstance<Node.Directory>()
                .map { deepFlatten(it.child) }
                .flatten().toList()
        )
