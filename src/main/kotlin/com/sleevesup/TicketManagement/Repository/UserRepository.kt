package com.sleevesup.TicketManagement.Repository

import com.sleevesup.TicketManagement.Model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, Int> {
    fun findByEmail(email:String): User?
}