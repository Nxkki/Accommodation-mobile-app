
package org.wit.accommodations.console.models

import mu.KotlinLogging
//import org.wit.placemark.console.helpers.exists
//import org.wit.placemark.console.helpers.read
//import org.wit.placemark.console.helpers.write
//import org.wit.accommodations.console.*

private val logger = KotlinLogging.logger {}

//set of one off declarations
//val JSON_FILE = "accommodations.json"
//val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
//val listType = object : TypeToken<java.util.ArrayList<AccommodationModel>>() {}.type

interface AccommodationStore {
    fun findAll(): List<AccommodationModel>
    fun findOne(id: Long): AccommodationModel?
    fun findPrice(price: Int) : AccommodationModel?
    fun create(accommodation: AccommodationModel)
    fun update(accommodation: AccommodationModel)
    fun delete(accommodation: AccommodationModel)

}
//fun generateRandomId(): Long {
//    return Random().nextLong()
//}
//
//class AccommodationJSONStore : AccommodationStore {
//
//    var accommodations = mutableListOf<AccommodationModel>()
//
//    init {
//        if (exists(JSON_FILE)) {
//            deserialize()
//        }
//    }
//
//    override fun findAll(): MutableList<AccommodationModel> {
//        return accommodations
//    }
//
//    override fun findOne(id: Long) : AccommodationModel? {
//        var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.id == id }
//        return foundAccommodation
//    }
//
//    override fun findPrice (price: Int) : AccommodationModel? {
//        var foundAccommodation: AccommodationModel? = accommodations.find { p -> p.price == price }
//        return foundAccommodation
//    }
//
//    override fun create(accommodations: AccommodationModel) {
//        accommodations.id = generateRandomId()
//        accommodations.add(accommodations)
//        serialize()
//    }
//
//    override fun delete(accommodations: AccommodationModel) {
//        var foundAccommodation = findOne(accommodations.id!!)
//        if (foundAccommodation != null) {
//
//            accommodations.remove(accommodations)
//        }
//    }
//    override fun update(accommodations: AccommodationModel) {
//        var foundAccommodation = findOne(accommodations.id!!)
//        if (foundAccommodation != null) {
//            foundAccommodation.price = accommodations.price
//            foundAccommodation.location = accommodations.location
//            foundAccommodation.type = accommodations.type
//            foundAccommodation.rooms = accommodations.rooms
//        }
//        serialize()
//    }
//
//    internal fun logAll() {
//        accommodations.forEach { logger.info("${it}") }
//    }
//
//    private fun serialize() {
//        val jsonString = gsonBuilder.toJson(accommodations, listType)
//        write(JSON_FILE, jsonString)
//    }
//
//    private fun deserialize() {
//        val jsonString = read(JSON_FILE)
//        accommodations = Gson().fromJson(jsonString, listType)
//    }


