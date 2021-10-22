//AccommodationStore declares what functionaltiy AccommodationStore will implement in other classes
//AccommodationStore is an interface
package org.wit.accommodations.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}


interface AccommodationStore {
    fun findAll(): List<AccommodationModel>
    fun findOne(id: Long): AccommodationModel?
    fun findPrice(price: Int) : AccommodationModel?
    fun create(accommodation: AccommodationModel)
    fun update(accommodation: AccommodationModel)
    fun delete(accommodation: AccommodationModel)

}


