//AccommodationController manages main functionality for the app
//AccommodationController acts as a link between Model and View

package org.wit.accommodations.console.controllers

import mu.KotlinLogging
import org.wit.accommodations.console.models.AccommodationJSONStore
import org.wit.accommodations.console.models.AccommodationModel
import org.wit.accommodations.console.views.AddAccommodationScreen
import org.wit.accommodations.console.views.DeleteAccommodationScreen
import org.wit.accommodations.console.views.ListAccommodationScreen
import org.wit.accommodations.console.views.MenuScreen
//import org.wit.accommodations.console.views.
//import org.wit.accommodations.console.views.MenuScreen
import tornadofx.*

class AccommodationUIController : Controller() {

    val accommodations = AccommodationJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Accommodation TornadoFX UI App" }
    }
    fun add(_price : Int, _location : String, _type : String, _rooms : String){

        var aAccommodation = AccommodationModel(price = _price, location = _location,type = _type, rooms = _rooms)
        accommodations.create(aAccommodation)
        logger.info("Accommodation Added")
    }

    fun delete(accommodation : AccommodationModel){

        accommodations.delete(accommodation)

        logger.info("Accommodation deleted")
    }
    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListAccommodationScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        accommodations.logAll()
    }

    fun loadAddScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddAccommodationScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadDeleteScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(DeleteAccommodationScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(AddAccommodationScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeList() {
        runLater {
            find(ListAccommodationScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeDelete() {
        runLater {
            find(DeleteAccommodationScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}