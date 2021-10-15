package org.wit.accomadation.console.main

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    logger.info { "Launching Accomdation Console App" }
    println("Accomdation Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> println("You Chose Add Accomdation")
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Accomadation Console App" }
}

fun menu() : Int {

    //user option
    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Accomadtion")
    println(" 2. Update Accomadtion")
    println(" 3. List All Accomadtion")
    println("-1. Exit")
    println()
    print("Enter a menu option : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}