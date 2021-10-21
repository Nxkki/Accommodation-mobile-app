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