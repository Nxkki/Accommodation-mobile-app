
package org.wit.accommodation.console.models

import org.wit.accommodation.console.helpers.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
//import org.wit.placemark.console.helpers.exists
//import org.wit.placemark.console.helpers.read
//import org.wit.placemark.console.helpers.write
//import org.wit.accommodation.console.*

import java.util.*

private val logger = KotlinLogging.logger {}

//set of one off declarations
val JSON_FILE = "accommodations.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<AccommodationModel>>() {}.type

interface AccommodationStore {
    fun findAll(): List<AccommodationModel>
    fun findOne(id: Long): AccommodationModel?
    fun create(accommodation: AccommodationModel)
    fun update(accommodation: AccommodationModel)
}
fun generateRandomId(): Long {
    return Random().nextLong()
}

class AccommodationJSONStore : AccommodationStore {

    var accommodations = mutableListOf<AccommodationModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<AccommodationModel> {
        return accommodations
    }

    override fun findOne(id: Long) : AccommodationModel? {
        var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.id == id }
        return foundAccommodation
    }

    override fun create(accommodation: AccommodationModel) {
        accommodation.id = generateRandomId()
        accommodations.add(accommodation)
        serialize()
    }

    override fun update(accommodation: AccommodationModel) {
        var foundAccommodation = findOne(accommodation.id!!)
        if (foundAccommodation != null) {
            foundAccommodation.price = accommodation.price
            foundAccommodation.location = accommodation.location
            foundAccommodation.type = accommodation.type
            foundAccommodation.rooms = accommodation.rooms
        }
        serialize()
    }

    internal fun logAll() {
        accommodations.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(accommodations, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        accommodations = Gson().fromJson(jsonString, listType)
    }
}

