//MenuScreen displays buttons on TornadoFX screen
//loads functions from accommodationUIController

package org.wit.accommodations.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
//import org.wit.accommodations.console.controllers.AccommodationUIController
import org.wit.accommodations.console.controllers.AccommodationUIController
import tornadofx.*

class MenuScreen : View("Accommodation Main Menu") {

    val accommodationUIController: AccommodationUIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Accommodation") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        accommodationUIController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List Accommodations") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        accommodationUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Delete Accommodations") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        accommodationUIController.loadDeleteScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }


}
