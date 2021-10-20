package org.wit.accommodations.console.models
//
//data class AccommodationModel(var id: Long = 0,
//                            var title: String = "",
//                            var description: String = "")

data class AccommodationModel(var id: Long = 0,
                              var price : Int = 0 ,
                              var location : String= "",
                              var  type : String= "",
                              var rooms : String = "")