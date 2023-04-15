package com.sleevesup.TicketManagement.Service

import com.sleevesup.TicketManagement.DTO.*
import com.sleevesup.TicketManagement.Model.Ticket

interface TicketService {
    fun createTicket(createticket: TicketRequestDto): String

//    fun getTickets(userId:UserIdDto) : List<TicketModel>
    fun getTicketList(): Any

    fun getTicket(ticketId:TicketIdDto) : Any

    fun getTicketsForUser(userId: Int) : Any

    fun getTicketsNotArchived() : List<Ticket>

    fun getTicketsArchived(): List<Ticket>

    fun statusUpdate(details:TicketDTO,id:Int) : String
}