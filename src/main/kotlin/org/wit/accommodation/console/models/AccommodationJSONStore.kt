package org.wit.accommodation.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
//import org.wit.accommodation.console.helpers.exists
//import org.wit.accommodation.console.helpers.read
//import org.wit.accommodation.console.helpers.write

import org.wit.accommodation.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "accommodations.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<AccommodationModel>>() {}.type

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

    override fun findPrice (price: Int) : AccommodationModel? {
                var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.price == price }
        return foundAccommodation
    }

    override fun findAll(): MutableList<AccommodationModel> {
        return accommodations
    }

    override fun findOne(id: Long) : AccommodationModel? {
        var foundAccommodation: AccommodationModel? = accommodations.find { c -> c.id == id }
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

    override fun delete( accommodation: AccommodationModel)
    {

        accommodations.remove(accommodation)
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