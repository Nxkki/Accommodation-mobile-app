package org.wit.accommodation.console.main
import org.wit.accommodation.console.controllers.AccommodationController
fun main(args: Array<String>) {
    val controller = AccommodationController().start()
}
//package org.wit.accommodation.console.main
//
//import mu.KotlinLogging
//import org.wit.accommodation.console.models.AccommodationModel
//import org.wit.accommodation.console.models.AccommodationMemStore
//import org.wit.accommodation.console.views.AccommodationView
//
////import org.wit.accommodation.console.models
////import org.wit.accommodation.console.models.AccommodationMemStore
////import org.wit.accommodation.console.models.AccommodationMemStore.kt
////import org.wit.accommodation.console.models.AccommodationModel
//
//private val logger = KotlinLogging.logger {}
//
//val accommodations = AccommodationMemStore()
//val accommodationView = AccommodationView()
//
////val accommodations = ArrayList<AccommodationModel>()
//
//fun main(args: Array<String>) {
//    logger.info { "Launching Accommodation Console App" }
//    println("Accommodation Kotlin App Version 1.0")
//
//    var input: Int
//
//    do {
//        input = menu()
//        when(input) {
//            1 -> addAccommodation()
//            2 -> updateAccommodation()
//            3 -> listAccommodations()
//            4 -> searchAccommodation()
//            -99 -> dummyData()
//            -1 -> println("Exiting App")
//            else -> println("Invalid Option")
//        }
//        println()
//    } while (input != -1)
//    logger.info { "Shutting Down Accommodation Console App" }
//}
//
//fun menu() : Int {
//
//    var option : Int
//    var input: String?
//
//    println("MAIN MENU")
//    println(" 1. Add Accommodation")
//    println(" 2. Update Accommodation")
//    println(" 3. List All Accommodations")
//    println(" 4. Search Accommodations")
//    println("-1. Exit")
//    println()
//    print("Enter Option : ")
//    input = readLine()!!
//    option = if (input.toIntOrNull() != null && !input.isEmpty())
//        input.toInt()
//    else
//        -9
//    return option
//}
////why isnt it adding
//fun addAccommodation() {
//
//    var anAccommodation = AccommodationModel()
//
//    if (accommodationView.addAccommodationData(anAccommodation))
//        accommodations.create(anAccommodation)
//    else
//        logger.info("Accommodation Not Added")
////    var anAccommodation = AccommodationModel()
////    println("Add Accommodation")
////    println()
////    print("Enter a Price : ")
////    anAccommodation.price = Integer.valueOf(readLine())
////    print("Enter a Location : ")
////    anAccommodation.location = readLine()!!
////    print("Enter a Type : ")
////    anAccommodation.type = readLine()!!
////    print("Enter a Rooms : ")
////    anAccommodation.rooms = readLine()!!
////    //here
////    if (anAccommodation.price != null&& anAccommodation.location.isNotEmpty() && anAccommodation.type.isNotEmpty() && anAccommodation.location.isNotEmpty()) {
//////        anAccommodation.id = accommodations //.size.toLong()
////        accommodations.create(anAccommodation.copy())
////        logger.info("Accommodation Added : [ $anAccommodation ]")
////    }
////    else
////        logger.info("Accommodation Not Added")
//}
//fun updateAccommodation() {
//
//    accommodationView.listAccommodations(accommodations)
//    var searchId = accommodationView.getId()
//    val aAccommodation = search(searchId)
//
//    if(aAccommodation != null) {
//        if(accommodationView.updateAccommodationData(aAccommodation)) {
//            accommodations.update(aAccommodation)
//            accommodationView.showAccommodation(aAccommodation)
//            logger.info("Accommodation Updated : [ $aAccommodation ]")
//        }
//        else
//            logger.info("Accommodation Not Updated")
//    }
//    else
//        println("Accommodation Not Updated...")
//}
//
////lab 3 below vvvvv
////fun updateAccommodation() {
////    println("Update Accommodation")
////    println()
////    listAccommodations()
////    var searchId = getId()
////    val anAccommodation = search(searchId)
////    var tempPrice : Int
////    var tempLocation : String?
////    var tempType : String?
////    var tempRoom : String?
//////    !tempPrice == 0
////
////    if(anAccommodation != null) {
////        print("Enter a new price for [ " + anAccommodation.price + " ] : ")
////        tempPrice = Integer.valueOf(readLine())
////        print("Enter a new lOCATION for [ " + anAccommodation.location + " ] : ")
////        tempLocation = readLine()!!
////        print("Enter a new TYPE for [ " + anAccommodation.type + " ] : ")
////        tempType = readLine()!!
////        print("Enter a new ROOM for [ " + anAccommodation.rooms + " ] : ")
////        tempRoom = readLine()!!
////
////        if (tempPrice != 0 && !tempLocation.isNullOrEmpty() && !tempType.isNullOrEmpty() && !tempRoom.isNullOrEmpty()) {
////        anAccommodation.price = tempPrice
////        anAccommodation.location = tempLocation
////        anAccommodation.type = tempType
////        anAccommodation.rooms = tempRoom
//////        print("Enter a new Price for [ " + anAccommodation.price + " ] : ")
//////        anAccommodation.price = Integer.valueOf(readLine())
//////        print("Enter a new Location for [ " + anAccommodation.location + " ] : ")
//////        anAccommodation.location = readLine()!!
//////        print("Enter a new Type for [ " + anAccommodation.type + " ] : ")
//////        anAccommodation.type = readLine()!!
//////        print("Enter a new Rooms for [ " + anAccommodation.rooms + " ] : ")
//////        anAccommodation.rooms = readLine()!!
////        println(
////            "You updated [ " + anAccommodation.price + " ] for price " +
////                    "and [ " + anAccommodation.location + " ] for location " +
////                    "and [ " + anAccommodation.type + " ] for type " +
////                    "and [ " + anAccommodation.rooms + " ] for description "
////
////        )
////    }
////    else
////        println("Accommodation Not Updated...")
////}
//
////else
////println("Accommodation Not Updated...")
////}
//
//fun listAccommodations() {
//    println("List All Accommodations")
//    println()
//    accommodations.logAll()
////    accommodations.forEach { logger.info("${it}") }
////    println()
//}
//
//fun searchAccommodation() {
//
//    val aAccommodation = search(accommodationView.getId())!!
//    accommodationView.showAccommodation(aAccommodation)
////    var searchId = getId()
////    val anAccommodation = search(searchId)
////
////    if(anAccommodation != null)
////        println("Accommodation Details [ $anAccommodation ]")
////    else
////        println("Accommodation Not Found...")
//}
////
////fun getId() : Long {
////    var strId : String? // String to hold user input
////    var searchId : Long // Long to hold converted id
////    print("Enter id to Search/Update : ")
////    strId = readLine()!!
////    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
////        strId.toLong()
////    else
////        -9
////    return searchId
////}
//
//fun search(id: Long) : AccommodationModel? {
//    var foundAccommodation: AccommodationModel? = accommodations.findOne(id)// { p -> p.id == id }
//    return foundAccommodation
//}
//
//fun dummyData() {
//    accommodations.create(AccommodationModel(1, 300, "Templars Hall", "two story house", "4"))
//    accommodations.create(AccommodationModel(2, 500, "Railway Square", "apartmnets", "2"))
//    accommodations.create(AccommodationModel(3, 200, "O connell street", "apartments", "3"))
//}