//when Main is called only an instance of AccommodationController is ran

package org.wit.accommodations.console.main
import org.wit.accommodations.console.controllers.AccommodationController
fun main(args: Array<String>) {
    AccommodationController().start()
}

