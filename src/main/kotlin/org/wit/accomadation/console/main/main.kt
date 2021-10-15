package org.wit.accommodation.console.main

import mu.KotlinLogging
import org.wit.accommodation.console.models.AccommodationModel

//import org.wit.accommodation.console.models.AccommodationModel

private val logger = KotlinLogging.logger {}

val accommodations = ArrayList<AccommodationModel>()

fun main(args: Array<String>) {
    logger.info { "Launching Accommodation Console App" }
    println("Accommodation Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addAccommodation()
            2 -> updateAccommodation()
            3 -> listAccommodations()
            4 -> searchAccommodation()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Accommodation Console App" }
}

fun menu() : Int {

    var option : Int
    var input: String?

    println("MAIN MENU")
    println(" 1. Add Accommodation")
    println(" 2. Update Accommodation")
    println(" 3. List All Accommodations")
    println(" 4. Search Accommodations")
    println("-1. Exit")
    println()
    print("Enter Option : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addAccommodation(){
    var anAccommodation = AccommodationModel()
    println("Add Accommodation")
    println()
    print("Enter a Price : ")
    anAccommodation.price = Integer.valueOf(readLine())
    print("Enter a Location : ")
    anAccommodation.location = readLine()!!
    print("Enter a Type : ")
    anAccommodation.type = readLine()!!
    print("Enter a Rooms : ")
    anAccommodation.rooms = readLine()!!
    //here
    if (anAccommodation.price == 0 && anAccommodation.location.isNotEmpty() && anAccommodation.type.isNotEmpty() && anAccommodation.location.isNotEmpty()) {
        anAccommodation.id = accommodations.size.toLong()
        accommodations.add(anAccommodation.copy())
        logger.info("Accommodation Added : [ $anAccommodation ]")
    }
    else
        logger.info("Accommodation Not Added")
}

fun updateAccommodation() {
    println("Update Accommodation")
    println()
    listAccommodations()
    var searchId = getId()
    val anAccommodation = search(searchId)

    if(anAccommodation != null) {
        print("Enter a new Price for [ " + anAccommodation.price + " ] : ")
        anAccommodation.price = Integer.valueOf(readLine())
        print("Enter a new Location for [ " + anAccommodation.location + " ] : ")
        anAccommodation.location = readLine()!!
        print("Enter a new Type for [ " + anAccommodation.type + " ] : ")
        anAccommodation.type = readLine()!!
        print("Enter a new Rooms for [ " + anAccommodation.rooms + " ] : ")
        anAccommodation.rooms = readLine()!!
        println(
            "You updated [ " + anAccommodation.price + " ] for price " +
                    "and [ " + anAccommodation.location + " ] for location " +
                    "and [ " + anAccommodation.type + " ] for type " +
                    "and [ " + anAccommodation.rooms + " ] for description "

        )
    }
    else
        println("Accommodation Not Updated...")
}

fun listAccommodations() {
    println("List All Accommodations")
    println()
    accommodations.forEach { logger.info("${it}") }
    println()
}

fun searchAccommodation() {

    var searchId = getId()
    val anAccommodation = search(searchId)

    if(anAccommodation != null)
        println("Accommodation Details [ $anAccommodation ]")
    else
        println("Accommodation Not Found...")
}

fun getId() : Long {
    var strId : String? // String to hold user input
    var searchId : Long // Long to hold converted id
    print("Enter id to Search/Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : AccommodationModel? {
    var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.id == id }
    return foundAccommodation
}

fun dummyData() {
    accommodations.add(AccommodationModel(1, 300, "Templars Hall", "two story house", "4"))
    accommodations.add(AccommodationModel(2, 500, "Railway Square", "apartmnets", "2"))
    accommodations.add(AccommodationModel(3, 200, "O connell street", "apartments", "3"))
}
