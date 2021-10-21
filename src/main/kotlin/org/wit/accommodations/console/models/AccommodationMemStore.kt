
package org.wit.accommodations.console.models
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class AccommodationMemStore : AccommodationStore {

    val accommodations = ArrayList<AccommodationModel>()

    override fun findAll(): List<AccommodationModel> {
        return accommodations
    }

    override fun findOne(id: Long) : AccommodationModel? {
        var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.id == id }
        return foundAccommodation
    }
    override fun findPrice (price: Int) : AccommodationModel? {
        var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.price == price }
        return foundAccommodation
    }

    override fun create(accommodation: AccommodationModel) {
        accommodation.id = getId()
        accommodations.add(accommodation)
        logAll()
    }



    override fun delete(accommodation: AccommodationModel) {
        var foundAccommodation = findOne(accommodation.id!!)
        if (foundAccommodation != null) {

            accommodations.remove(accommodation)
        }
    }
    override fun update(accommodation: AccommodationModel) {
        var foundAccommodation = findOne(accommodation.id!!)
        if (foundAccommodation != null) {
            foundAccommodation.price = accommodation.price
            foundAccommodation.location = accommodation.location
            foundAccommodation.type = accommodation.type
            foundAccommodation.rooms = accommodation.rooms
        }
    }

    internal fun logAll() {
        accommodations.forEach { logger.info("${it}") }
    }
}