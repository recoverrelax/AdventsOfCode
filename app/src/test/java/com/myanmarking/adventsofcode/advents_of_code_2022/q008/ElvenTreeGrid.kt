package com.myanmarking.adventsofcode.advents_of_code_2022.q008

class ElvenTreeGrid(
    trees: List<String>
) : Iterable<ElementInfo> {
    private val grid: List<List<Int>> = trees.map { line: String ->
        line.toCharArray().map { char: Char -> char.digitToInt() }
    }

    init {
        check(grid.map { it.size }.toSet().size == 1)
    }

    override fun iterator(): Iterator<ElementInfo> = TreeIterator(grid)

    class TreeIterator(
        private val grid: List<List<Int>>
    ) : Iterator<ElementInfo> {
        private val outerSize: Int = grid.size
        private val innerSize: Int = grid.first().size

        private var outerIndex: Int = 0
        private var innerIndex: Int = -1

        override fun hasNext(): Boolean = when (outerIndex) {
            innerSize - 1 -> innerIndex < innerSize - 1
            else -> true
        }

        override fun next(): ElementInfo {
            when {
                innerIndex < innerSize - 1 -> innerIndex += 1
                outerIndex < outerSize - 1 -> {
                    outerIndex += 1
                    innerIndex = 0
                }
            }
            return ElementInfo.Impl(
                element = grid[outerIndex][innerIndex],
                isEdge = outerIndex == 0 || outerIndex == outerSize - 1 || innerIndex == 0 || innerIndex == innerSize - 1,
                grid = grid,
                outerIndex = outerIndex,
                innerIndex = innerIndex
            )
        }
    }
}