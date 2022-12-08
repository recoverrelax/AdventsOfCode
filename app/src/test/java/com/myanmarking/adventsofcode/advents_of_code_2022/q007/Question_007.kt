package com.myanmarking.adventsofcode.advents_of_code_2022.q007

import com.myanmarking.adventsofcode.utils.AdventsOfCodeIntTest

class Question_007: AdventsOfCodeIntTest() {
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
                    currentDirectory.add(
                        Node.Directory(
                            name = command.removePrefix("dir "),
                            parent = currentDirectory
                        )
                    )
                    index += 1
                }

                command.startsWith("$ cd ..") -> {
                    currentDirectory = checkNotNull(currentDirectory.parent)
                    index += 1
                }

                command.startsWith("$ cd") -> {
                    currentDirectory = currentDirectory
                        .findDirectoryByName(
                            command.removePrefix("$ cd ")
                        )

                    // always followed by ls
                    index += 2
                }

                command.first().isDigit() -> {
                    val (size, name) = command.split(" ")
                    val file = Node.File(
                        name = name,
                        size = size.toInt()
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

    override fun answer1(input: String): Int {
        val fileSystem: Node.Directory = buildFileTree(input)

        return fileSystem.getAllDirectories()
            .map { it.totalSize }
            .filter { it <= 100_000 }
            .sum()
    }

    override fun answer2(input: String): Int {
        val fileSystem: Node.Directory = buildFileTree(input)

        val totalDiskSpace = 70_000_000
        val minUnusedSpace = 30_000_000
        val totalDirectorySize = fileSystem.totalSize
        val unusedSpace = totalDiskSpace - totalDirectorySize
        val spaceRequired = minUnusedSpace - unusedSpace

        return fileSystem.getAllDirectories()
            .also { print("Size: ${it.size}") }
            .map { it.totalSize }
            .filter { it >= spaceRequired }
            .min()
    }
}