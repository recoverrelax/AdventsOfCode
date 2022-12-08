package com.myanmarking.adventsofcode.advents_of_code_2022.q007

import com.myanmarking.adventsofcode.utils.readFile
import org.junit.Test
import java.lang.UnsupportedOperationException

class Question_007 {
    private val input: String = this.javaClass.readFile("input_07")

    private fun buildFileTree(input: String): Node.Directory {
        val commands = input.lines()

        val tree: Node.Directory = Node.Directory(name = "root", parent = null)
        lateinit var currentDirectory: Node.Directory

        var index = 0

        while (index < commands.size) {
            val command = commands[index]
            when {
                command == "$ cd /" -> {
                    currentDirectory = tree
                    // always followed by ls
                    index += 2
                }

                command.startsWith("dir") -> {
                    val dirName = command.removePrefix("dir ")
                    val directory = Node.Directory(name = dirName, parent = currentDirectory)
                    currentDirectory.child.add(directory)
                    index += 1
                }

                command.startsWith("$ cd ..") -> {
                    currentDirectory = checkNotNull(currentDirectory.parent)
                    index += 1
                }

                command.startsWith("$ cd") -> {
                    val dirName = command.removePrefix("$ cd ")
                    // always followed by ls
                    currentDirectory =
                        currentDirectory.child.first { it is Node.Directory && it.name == dirName } as Node.Directory

                    // always followed by ls
                    index += 2
                }

                command.first().isDigit() -> {
                    val split = command.split(" ")
                    val size = split[0].toInt()
                    val name = split[1]
                    val file = Node.File(
                        name = name,
                        size = size
                    )
                    currentDirectory.child.add(file)
                    index += 1
                }

                else -> {
                    throw UnsupportedOperationException()
                }
            }
        }
        return tree
    }

    @Test
    fun test() {
        val fileSystem: Node.Directory = buildFileTree(input)

        // find all of the directories with a total size of at most 100000
        println(
            "answer1: " + fileSystem.getAllDirectories()
                .map { it.totalSize }
                .filter { it <= 100_000 }
                .sum()
        )

        val totalDiskSpace = 70_000_000
        val minUnusedSpace = 30_000_000
        val totalDirectorySize = fileSystem.totalSize

        val unusedSpace = totalDiskSpace - totalDirectorySize

        val spaceRequired = minUnusedSpace - unusedSpace

        println(
            "answer2: " + fileSystem.getAllDirectories()
                .map { it.totalSize }
                .filter { it >= spaceRequired }
                .min()
        )
    }
}