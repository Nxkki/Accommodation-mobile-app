//ListAccommodationScreen uses TornadoFX tableView to list all accommodations created from accommmodation.json
//Close button returns user to MenuScreen
package org.wit.accommodations.console.views


import org.wit.accommodations.console.models.AccommodationModel
import org.wit.accommodations.console.controllers.AccommodationUIController
import tornadofx.*

class ListAccommodationScreen : View("List Accommodations") {

    val accommodationUIController: AccommodationUIController by inject()
    val tableContent = accommodationUIController.accommodations.findAll()
    val data = tableContent.observable()


    override val root = vbox {
        setPrefSize(600.0, 200.0)
        tableview(data) {
            readonlyColumn("ID", AccommodationModel::id)
            readonlyColumn("PRICE", AccommodationModel::price)
            readonlyColumn("LOCATION", AccommodationModel::location)
            readonlyColumn("TYPE", AccommodationModel::type)
            readonlyColumn("ROOMS", AccommodationModel::rooms)
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    accommodationUIController.closeList()
                }
            }
        }
    }

}