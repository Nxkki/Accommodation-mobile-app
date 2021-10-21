package org.wit.accommodations.console.views


//import org.wit.accommodations.console.main.accommodations
import org.wit.accommodations.console.models.AccommodationJSONStore
import org.wit.accommodations.console.models.AccommodationModel

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
        println(" 6. Price search Accommodations")
        println(" 7 Price filter Accommodations")
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
//        accommodations.title = readLine()!!
//        print("Enter a Description : ")
//        accommodations.description = readLine()!!

//        return accommodations.title.isNotEmpty() && accommodations.description.isNotEmpty()
        return accommodation.price != null && accommodation.location.isNotEmpty() && accommodation.type.isNotEmpty() && accommodation.rooms.isNotEmpty()

    }

    fun deleteAccommodationData(accommodation: AccommodationModel): Boolean {
        if (accommodation != null) {
//            if ( accommodations.price != 0 && ! accommodations.location.isNullOrEmpty() && ! accommodations.type.isNullOrEmpty() && ! accommodations.rooms.isNullOrEmpty()) {
//
//            accommodations == null
            return true
//            }
        } else return false
    }


    //        accommodations.findOne(accommodations)
//
//       accommodations.accommodations.remove(accommodations.accommodations.removeAt())
//        if (accommodations != null){
//
//            deleteAccommodationData(accommodations)
//        }

//        var index : Int
//        print("Enter the index of the accommodations to delete ==>")
//        index = Integer.valueOf(readLine())
//
//        if (accommodations != null) {
//
//            accommodations.
//        }
////        if (index < 0) {
////
////        } else if (accommodations.id < accommodations) {
////            accommodations.remove(accommodations.id);
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
//            print("Enter a new Title for [ " + accommodations.title + " ] : ")
//            tempTitle = readLine()!!
//            print("Enter a new Description for [ " + accommodations.description + " ] : ")
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
//                accommodations.title = tempTitle
//                accommodations.description = tempDescription
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

    fun getPrice(): Int {
        var strPrice: String? // String to hold user input
        var searchPrice: Int // Long to hold converted id
        print("Enter Exact Price:")
        strPrice = readLine()!!
        searchPrice = if (strPrice.toIntOrNull() != null && !strPrice.isEmpty())
            strPrice.toInt()
        else
            -9
        return searchPrice
    }

    fun getFilterPrice(): Int {
        var strFilterPrice: String? // String to hold user input
        var searchFilterPrice: Int // Long to hold converted id
        print("Enter Exact Price:")
        strFilterPrice = readLine()!!
        searchFilterPrice = if (strFilterPrice.toIntOrNull() != null && !strFilterPrice.isEmpty())
            strFilterPrice.toInt()
        else
            -9
        return searchFilterPrice
    }

    fun showAccommodation(accommodation: List<AccommodationModel>) {
        if (accommodation != null)
            println("Accommodation Details [ $accommodation ]")
        else
            println("Accommodation Not Found...")
    }
}