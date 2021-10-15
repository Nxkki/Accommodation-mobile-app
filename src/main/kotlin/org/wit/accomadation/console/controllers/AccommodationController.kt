package org.wit.accommodation.console.controllers

import mu.KotlinLogging
import org.wit.accommodation.console.models.AccommodationMemStore
import org.wit.accommodation.console.models.AccommodationModel
import org.wit.accommodation.console.views.AccommodationView

class AccommodationController {

    val accommodations = AccommodationMemStore()
    val accommodationView = AccommodationView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Accommodation Console App" }
        println("Accommodation Kotlin App Version 1.0")
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
                logger.info("Accommodation Not Updated")
        }
        else
            println("Accommodation Not Updated...")
    }

    fun search() {
        val aAccommodation = search(accommodationView.getId())!!
        accommodationView.showAccommodation(aAccommodation)
    }


    fun search(id: Long) : AccommodationModel? {
        var foundAccommodation = accommodations.findOne(id)
        return foundAccommodation
    }

    fun dummyData() {
        accommodations.create(AccommodationModel(1, 300, "Templars Hall", "two story house", "4"))
        accommodations.create(AccommodationModel(2, 500, "Railway Square", "apartmnets", "2"))
        accommodations.create(AccommodationModel(3, 200, "O connell street", "apartments", "3"))
    }
}