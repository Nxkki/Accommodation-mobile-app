//DeleteAccommodationScreen displays accommodation using TornadoFXs tableView to list all accommodations created from accommodation.json
//onUserSelect is used to allow user to select the accommodation they could like to delete and a double click it is deleted
//the screen is then refreshed to display new list of accommodations
//Close button returns user to MenuScreen
package org.wit.accommodations.console.views

import org.wit.accommodations.console.controllers.AccommodationUIController
import org.wit.accommodations.console.models.AccommodationModel
import tornadofx.*



class DeleteAccommodationScreen : View("Delete Accommodations") {

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
            onUserSelect{ accom -> accommodationUIController.delete(accom)
                this.refresh()}

        }

        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    accommodationUIController.closeDelete()

                }
            }
        }
    }

}