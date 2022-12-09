package com.myanmarking.adventsofcode.advents_of_code_2022.q008

interface ElementInfo {
    val element: Int
    val isEdge: Boolean

    fun getDirectionElements(direction: Direction): List<Int>

    data class Impl(
        override val element: Int,
        override val isEdge: Boolean,
        private val grid: List<List<Int>>,
        private val outerIndex: Int,
        private val innerIndex: Int,
    ) : ElementInfo {
        private val innerLastIndex = grid.first().lastIndex
        private val outerLastIndex = grid.lastIndex

        override fun getDirectionElements(direction: Direction): List<Int> {
            return when (direction) {
                Direction.UP -> {
                    if(outerIndex == 0){
                        emptyList()
                    } else {
                        (0 until outerIndex).toList()
                            .map { grid[it][innerIndex] }
                    }
                }
                Direction.DOWN -> {
                    if(outerIndex == innerLastIndex){
                        emptyList()
                    } else {
                        (outerIndex + 1 until outerLastIndex + 1).toList()
                            .map { grid[it][innerIndex] }
                    }
                }
                Direction.LEFT -> {
                    if(innerIndex == 0){
                        emptyList()
                    } else{
                        (0 until innerIndex).toList()
                            .map { grid[outerIndex][it] }
                    }
                }
                Direction.RIGHT -> {
                    if(innerIndex == innerLastIndex){
                        emptyList()
                    } else{
                        (innerIndex + 1 until innerLastIndex + 1).toList()
                            .map { grid[outerIndex][it] }
                    }
                }
            }
        }
    }
}