package com.sleevesup.TicketManagement.Controller

import com.sleevesup.TicketManagement.DTO.*
import com.sleevesup.TicketManagement.Service.TicketService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("api/v1")
class TicketController(private val ticketService: TicketService) {

    @PostMapping("create-ticket")
    fun createTicket(@RequestBody ticketInfo:TicketRequestDto) : ResponseEntity<Any>{
        val result = ticketService.createTicket(ticketInfo)
        return ResponseEntity.ok(result)
    }

    @GetMapping("tickets")
    fun getTickets(@RequestBody userId: UserIdDto) : ResponseEntity<Any>{
        val result = ticketService.getTicketsForUser(userId.id)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/get-tickets")
    fun getticketlist():ResponseEntity<Any>{
        val result = ticketService.getTicketList()
        return ResponseEntity.ok(result)
    }

    @GetMapping("/get-ticket")
    fun getTicketForTicketId(@RequestBody ticketId:TicketIdDto) : ResponseEntity<Any>{
        val result = ticketService.getTicket(ticketId)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/not-archived")
    fun notArchived() : ResponseEntity<Any>{
        val result = ticketService.getTicketsNotArchived()
        return ResponseEntity.ok(result)
    }

    @GetMapping("/archived")
    fun archived() : ResponseEntity<Any>{
        val result = ticketService.getTicketsArchived()
        return ResponseEntity.ok(result)
    }

    @PutMapping("/statusUpdate/{id}")
    fun statusupdate(@RequestBody details:TicketDTO,@PathVariable id:Int) : ResponseEntity<Any>{
        val result = ticketService.statusUpdate(details,id)
        return ResponseEntity.ok(result)
    }

}