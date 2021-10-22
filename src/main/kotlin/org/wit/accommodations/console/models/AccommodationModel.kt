//AccommodationModel stores accommodation objects and manages user data
//AccommodationModel is a data class

package org.wit.accommodations.console.models


data class AccommodationModel(var id: Long = 0,
                              var price : Int = 0 ,
                              var location : String= "",
                              var  type : String= "",
                              var rooms : String = "")