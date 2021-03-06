//AccommodationController manages main functionality for the app
//AccommodationController acts as a link between Model and View


package org.wit.accommodations.console.controllers

import mu.KotlinLogging
import org.wit.accommodations.console.models.AccommodationJSONStore
import org.wit.accommodations.console.models.AccommodationModel
import org.wit.accommodations.console.views.AccommodationView

class AccommodationController {


    val accommodations = AccommodationJSONStore()
    val red = "\u001b[31m"
    val reset = "\u001b[0m"
    val accommodationView = AccommodationView()

    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Accommodation Console App"}
        println(red +"Accommodation Kotlin App Version 1.0" + reset)
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
                7 -> filteringPrice()
                -99 -> dummyData()
                -1 -> println(red + "Exiting App"+ reset)
                else -> println(red + "Invalid Option" + reset)
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


                accommodations.delete(aAccommodation)
                accommodationView.showAccommodation(aAccommodation)

                logger.info("Accommodation  Deleted...")

        }
        else
            logger.info("Accommodation Not Deleted...")

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

    fun filteringPrice() {
        val Accommodations = filterPrice(accommodationView.getFilterPrice())!!
        return accommodationView.showAccommodation(Accommodations)
    }

    fun search(id: Long) : AccommodationModel? {
        var foundAccommodation = accommodations.findOne(id)
        return foundAccommodation
    }

    fun searchPrice(price: Int) : AccommodationModel? {
        var foundAccommodation = accommodations.findPrice(price)
        return foundAccommodation
    }

    fun filterPrice(price: Int): List<AccommodationModel> {

   var foundAccommodation = accommodations.filteringPrice(price)
    return foundAccommodation
}
    fun dummyData() {
        accommodations.create(AccommodationModel(1, 300, "Templars Hall", "two story house", "4"))
        accommodations.create(AccommodationModel(2, 500, "Railway Square", "apartmnets", "2"))
        accommodations.create(AccommodationModel(3, 200, "O connell street", "apartments", "3"))
    }
}