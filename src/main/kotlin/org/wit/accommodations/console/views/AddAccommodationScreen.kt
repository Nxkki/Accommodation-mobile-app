//AddAccommodationScreen allows users to enter details tht are then used to create a new accommodation
//new accommodation is stored in  accommodation.json
//Close button returns user to MenuScreen

package org.wit.accommodations.console.views

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.accommodations.console.controllers.AccommodationUIController
import tornadofx.*

class AddAccommodationScreen : View("Add Accommodation") {
    val model = ViewModel()
    val _price = model.bind { SimpleIntegerProperty() }
    val _location = model.bind { SimpleStringProperty() }
    val _type = model.bind { SimpleStringProperty() }
    val _rooms = model.bind { SimpleStringProperty() }
    val accommodationUIController: AccommodationUIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Price") {
                textfield(_price).required()
            }
            field("location") {
                textarea(_location).required()
            }
            field("Type") {
                textfield(_type).required()
            }
            field("Rooms") {
                textfield(_rooms).required()
            }
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        accommodationUIController.add(
                            _price.value.toInt(),
                            _location.getValue(),
                            _type.getValue(),
                            _rooms.getValue()
                        )


                    }
                }
            }
                button("Close") {
                    useMaxWidth = true
                    action {
                        runAsyncWithProgress {
                            accommodationUIController.closeAdd()
                        }
                    }
                }
            }



    fun onDock() {
    _price.value = null
            _location.value = ""
            _type.value = ""
            _rooms.value = ""
            model.clearDecorators()
        }
    }
}