package com.sleevesup.TicketManagement.Model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name="ticket")
data class Ticket(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = -1,

    @Column
    var title: String,

    @Column
    var description: String,

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="assigned_user_id")
    var assignTo:User,

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="reporter_id")
    var reporter: User,

    @Column
    var status: String,
)




