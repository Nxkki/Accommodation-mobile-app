package org.wit.accommodations.console.controllers

import mu.KotlinLogging
import org.wit.accommodations.console.models.AccommodationJSONStore
import org.wit.accommodations.console.models.AccommodationModel
import org.wit.accommodations.console.views.AccommodationView

class AccommodationController {

//   val accommodations = AccommodationMemStore()
    val accommodations = AccommodationJSONStore()

    val accommodationView = AccommodationView()

    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Accommodation Console App" }
        println("Accommodation Kotlin App Version 1.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                6 -> searchPrice()
                -99 -> dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }

    fun menu() :Int { return accommodationView.menu() }

    fun add(){
        var aAccommodation = AccommodationModel()

        if (accommodationView.addAccommodationData(aAccommodation))
            accommodations.create(aAccommodation)
        else
            logger.info("Accommodation Not Added")
    }

    fun list() {
        accommodationView.listAccommodations(accommodations)
    }

    fun delete(){

        accommodationView.listAccommodations(accommodations)
        var searchId = accommodationView.getId()
        val aAccommodation = search(searchId)

        if(aAccommodation != null) {

//            if(accommodationView.deleteAccommodationData(aAccommodation)) {
//                accommodationView.deleteAccommodationData(aAccommodation)
//            if (accommodationView.deleteAccommodationData(aAccommodation)) {
                accommodations.delete(aAccommodation)
                accommodationView.showAccommodation(aAccommodation)

                logger.info("Accommodation  Deleted...")

        }
        else
            logger.info("Accommodation Not Deleted...")
//    }
//        else
//        println("Accommodation Not Deleted...")
    }




    fun update() {

        accommodationView.listAccommodations(accommodations)
        var searchId = accommodationView.getId()
        val aAccommodation = search(searchId)

        if(aAccommodation != null) {
            if(accommodationView.updateAccommodationData(aAccommodation)) {
                accommodations.update(aAccommodation)
                accommodationView.showAccommodation(aAccommodation)
                logger.info("Accommodation Updated : [ $aAccommodation ]")
            }
            else
                logger.info("Accommodationa Not Updated")
        }
        else
            println("Accommodation Not Updated...")
    }

    fun search() {
        val aAccommodation = search(accommodationView.getId())!!
        accommodationView.showAccommodation(aAccommodation)
    }
    fun searchPrice() {
        val aAccommodation = searchPrice(accommodationView.getPrice())!!
        accommodationView.showAccommodation(aAccommodation)
    }

    fun search(id: Long) : AccommodationModel? {
        var foundAccommodation = accommodations.findOne(id)
        return foundAccommodation
    }

    fun searchPrice(price: Int) : AccommodationModel? {
        var foundAccommodation = accommodations.findPrice(price)
        return foundAccommodation
    }
    fun dummyData() {
        accommodations.create(AccommodationModel(1, 300, "Templars Hall", "two story house", "4"))
        accommodations.create(AccommodationModel(2, 500, "Railway Square", "apartmnets", "2"))
        accommodations.create(AccommodationModel(3, 200, "O connell street", "apartments", "3"))
    }
}