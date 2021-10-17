package org.wit.accommodation.console.views


//import org.wit.accommodation.console.main.accommodations
import org.wit.accommodation.console.models.AccommodationJSONStore
import org.wit.accommodation.console.models.AccommodationMemStore
import org.wit.accommodation.console.models.AccommodationModel
import org.wit.accommodation.console.models.AccommodationStore

class AccommodationView {

    fun menu(): Int {

        var option: Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Accommodation")
        println(" 2. Update Accommodation")
        println(" 3. List All Accommodations")
        println(" 4. Search Accommodations")
        println(" 5. Delete Accommodations")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listAccommodations(accommodations: AccommodationJSONStore) {
        println("List All Accommodations")
        println()
        accommodations.logAll()
        println()
    }

    fun showAccommodation(accommodation: AccommodationModel) {
        if (accommodation != null)
            println("Accommodation Details [ $accommodation ]")
        else
            println("Accommodation Not Found...")
    }

    fun addAccommodationData(accommodation: AccommodationModel): Boolean {

        println()
        print("Enter a Price : ")
        accommodation.price = Integer.valueOf(readLine())
        print("Enter a Location : ")
        accommodation.location = readLine()!!
        print("Enter a Type : ")
        accommodation.type = readLine()!!
        print("Enter a Rooms : ")
        accommodation.rooms = readLine()!!
//        print("Enter a Title : ")
//        accommodation.title = readLine()!!
//        print("Enter a Description : ")
//        accommodation.description = readLine()!!

//        return accommodation.title.isNotEmpty() && accommodation.description.isNotEmpty()
        return accommodation.price != null && accommodation.location.isNotEmpty() && accommodation.type.isNotEmpty() && accommodation.rooms.isNotEmpty()

    }

    fun deleteAccommodationData(accommodation: AccommodationModel): Boolean {
        if (accommodation != null) {
//            if ( accommodation.price != 0 && ! accommodation.location.isNullOrEmpty() && ! accommodation.type.isNullOrEmpty() && ! accommodation.rooms.isNullOrEmpty()) {
//
//            accommodation == null
                return true
//            }
        } else return false
    }


    //        accommodation.findOne(accommodation)
//
//       accommodation.accommodations.remove(accommodation.accommodations.removeAt())
//        if (accommodation != null){
//
//            deleteAccommodationData(accommodation)
//        }

//        var index : Int
//        print("Enter the index of the accommodation to delete ==>")
//        index = Integer.valueOf(readLine())
//
//        if (accommodation != null) {
//
//            accommodation.
//        }
////        if (index < 0) {
////
////        } else if (accommodation.id < accommodation) {
////            accommodation.remove(accommodation.id);
////            return true;
////        } else {
////            return false;
////        }


    fun updateAccommodationData(accommodation: AccommodationModel): Boolean {

//        var tempTitle: String?
//        var tempDescription: String?

        var tempPrice: Int
        var tempLocation: String?
        var tempType: String?
        var tempRoom: String?

        if (accommodation != null) {
//            print("Enter a new Title for [ " + accommodation.title + " ] : ")
//            tempTitle = readLine()!!
//            print("Enter a new Description for [ " + accommodation.description + " ] : ")
//            tempDescription = readLine()!!
            print("Enter a new price for [ " + accommodation.price + " ] : ")
            tempPrice = Integer.valueOf(readLine())
            print("Enter a new lOCATION for [ " + accommodation.location + " ] : ")
            tempLocation = readLine()!!
            print("Enter a new TYPE for [ " + accommodation.type + " ] : ")
            tempType = readLine()!!
            print("Enter a new ROOM for [ " + accommodation.rooms + " ] : ")
            tempRoom = readLine()!!

            if (tempPrice != 0 && !tempLocation.isNullOrEmpty() && !tempType.isNullOrEmpty() && !tempRoom.isNullOrEmpty()) {
//            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
//                accommodation.title = tempTitle
//                accommodation.description = tempDescription
                accommodation.price = tempPrice
                accommodation.location = tempLocation
                accommodation.type = tempType
                accommodation.rooms = tempRoom
                return true
            }
        }
        return false
    }

    fun getId(): Long {
        var strId: String? // String to hold user input
        var searchId: Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}
