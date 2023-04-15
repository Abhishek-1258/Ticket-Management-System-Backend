package com.sleevesup.TicketManagement.DTO

class TicketRequestDto(
    var title:String,
    var description:String,
    var assignTo:Int,
    var reporter:Int,
    var status:String
){

}