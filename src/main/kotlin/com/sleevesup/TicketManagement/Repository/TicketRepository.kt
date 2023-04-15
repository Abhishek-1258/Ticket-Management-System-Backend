package com.sleevesup.TicketManagement.Repository

import com.sleevesup.TicketManagement.Model.Ticket
import com.sleevesup.TicketManagement.Model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TicketRepository: JpaRepository<Ticket, Int>  {

    fun findByAssignTo(user: User): List<Ticket>


}