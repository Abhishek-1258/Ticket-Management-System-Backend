package com.sleevesup.TicketManagement.Service

import com.sleevesup.TicketManagement.DTO.*
import com.sleevesup.TicketManagement.Model.Ticket

import com.sleevesup.TicketManagement.Repository.TicketRepository
import com.sleevesup.TicketManagement.Repository.UserRepository
import org.springframework.stereotype.Service


@Service
class TicketServiceImpl(
    private val ticketRepository: TicketRepository,
    private val userRepository: UserRepository):TicketService {

    override fun createTicket(createticket: TicketRequestDto): String {
        val assignedUser = userRepository.findById(createticket.assignTo).get()
        val reporterUser = userRepository.findById(createticket.reporter).get()
        return try {
            val ticket = Ticket(
                title = createticket.title,
                description = createticket.description,
                assignTo = assignedUser,
                reporter = reporterUser,
                status = createticket.status
            )
            val savedTicket = ticketRepository.save(ticket)
            "${ticket.title} has been added"
        } catch (ex:Exception){
            "ticket cannot  be created"
        }
    }

    override fun getTicketList(): Any {
        return ticketRepository.findAll()
    }

    override fun getTicket(ticketId: TicketIdDto): Ticket {
        return ticketRepository.findById(ticketId.id).get()
    }

    override fun getTicketsForUser(userId: Int): Any {
        val user = userRepository.findById(userId).get()
        return ticketRepository.findByAssignTo(user)
    }

    override fun getTicketsNotArchived():List<Ticket>{
        val ticketsList:List<Ticket> = ticketRepository.findAll()
        val notArchiveList: MutableList<Ticket> = mutableListOf<Ticket>()
        for (ticket in ticketsList ){
            if(ticket.status != "Archive"){
                notArchiveList.add(ticket)
            }
        }
        return notArchiveList
    }

    override fun getTicketsArchived():List<Ticket>{
        val ticketsList:List<Ticket> = ticketRepository.findAll()
        val notArchiveList: MutableList<Ticket> = mutableListOf<Ticket>()
        for (ticket in ticketsList ){
            if(ticket.status == "Archive"){
                notArchiveList.add(ticket)
            }
        }
        return notArchiveList
    }

    override fun statusUpdate(details: TicketDTO, id: Int): String {
        val assignedUser = userRepository.findById(details.assignTo).get()
        val reporterUser = userRepository.findById(details.reporter).get()
        var ticket = Ticket(
            id = id,
            title = details.title,
            description = details.description,
            assignTo = assignedUser,
            reporter = reporterUser,
            status = details.status
        )
        if(ticket != null){
            ticket = ticketRepository.save(ticket)
            return "${ticket.title} status has been updated"}
        else{
            return "Enter valid details"
        }
    }

}