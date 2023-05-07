package com.sleevesup.TicketManagement.Service
import com.sleevesup.TicketManagement.DTO.UserLoginDto
import com.sleevesup.TicketManagement.Model.User

interface UserService {

    fun createUser(userInfo: UserLoginDto) : String

    fun updateUser(userUpdate:UserLoginDto,id:Int):String

    fun getUsers():List<User>
    
    fun getticketList(userUpdate: UserLoginDto): Any



}