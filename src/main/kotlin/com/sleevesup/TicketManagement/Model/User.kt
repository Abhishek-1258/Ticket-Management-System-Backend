package com.sleevesup.TicketManagement.Model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*



@Table(name="userdata")
@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = -1,

    @Column
    var name: String,

    @Column
    var age:Int,

    @Column
    var phonenumber:String,

    @Column
    var email:String,

    @OneToMany(mappedBy = "assignTo")
    @JsonIgnore
    var ticketList: MutableSet<Ticket> = mutableSetOf()

    )
