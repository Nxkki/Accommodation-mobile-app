import org.wit.accommodation.console.models.AccommodationModel

interface AccommodationStore {
    fun findAll(): List<AccommodationModel>
    fun findOne(id: Long): AccommodationModel?
    fun create(accommodation: AccommodationModel)
    fun update(accommodation: AccommodationModel)
}