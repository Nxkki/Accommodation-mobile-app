//AccommodationView displays options to the user in a Menu format
//AccommodationView contains listAccommodations, showAccommodation, addAccommodationData, updateAccommodationData, getId, getPrice and getFilterPrice
//user input required for add,delete and update functions is obtained here
//AccommodationView is 'User Facing'
package org.wit.accommodations.console.views


import org.wit.accommodations.console.models.AccommodationJSONStore
import org.wit.accommodations.console.models.AccommodationModel

class AccommodationView {
    val yellow = "\u001b[33m"
    val blue = "\u001b[34m"
    val green = "\u001b[32m"
    val reset = "\u001b[0m"

    fun menu(): Int {

        var option: Int
        var input: String?

        println(yellow + "----------------------------------------------------------------------" + reset)
        println( yellow +"MAIN MENU" + reset)
        println(yellow + "----------------------------------------------------------------------" + reset)

        println(blue + " 1. Add Accommodation"+ reset)
        println(blue +" 2. Update Accommodation" + reset)
        println(blue +" 3. List All Accommodations"+ reset)
        println(blue +" 4. Search Accommodations"+ reset)
        println(blue +" 5. Delete Accommodations" + reset)
        println(blue +" 6. Price search Accommodations"+ reset)
        println(blue +" 7 Price filter Accommodations" + reset)
        println(blue +"-1. Exit")
        println(yellow + "----------------------------------------------------------------------" + reset)

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

        return accommodation.price != null && accommodation.location.isNotEmpty() && accommodation.type.isNotEmpty() && accommodation.rooms.isNotEmpty()

    }

    fun updateAccommodationData(accommodation: AccommodationModel): Boolean {



        var tempPrice: Int
        var tempLocation: String?
        var tempType: String?
        var tempRoom: String?

        if (accommodation != null) {

            print("Enter a new price for [ " + accommodation.price + " ] : ")
            tempPrice = Integer.valueOf(readLine())
            print("Enter a new lOCATION for [ " + accommodation.location + " ] : ")
            tempLocation = readLine()!!
            print("Enter a new TYPE for [ " + accommodation.type + " ] : ")
            tempType = readLine()!!
            print("Enter a new ROOM for [ " + accommodation.rooms + " ] : ")
            tempRoom = readLine()!!

            if (tempPrice != 0 && !tempLocation.isNullOrEmpty() && !tempType.isNullOrEmpty() && !tempRoom.isNullOrEmpty()) {
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

