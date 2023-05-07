package com.sleevesup.TicketManagement.Service

import com.sleevesup.TicketManagement.DTO.UserLoginDto
import com.sleevesup.TicketManagement.Model.User
import com.sleevesup.TicketManagement.Repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService{

    override fun createUser(userInfo:UserLoginDto): String {
        val user = User(
            name = userInfo.name,
            age = userInfo.age,
            phonenumber = userInfo.phonenumber,
            email = userInfo.email
        )
        val createdUser = userRepository.save(user)
        return "${createdUser.name} details has been added"
    }

    override  fun updateUser(userUpdate: UserLoginDto,id: Int) : String {
        var user = User(
            id = id,
            name = userUpdate.name,
            age = userUpdate.age,
            phonenumber = userUpdate.phonenumber,
            email = userUpdate.email)
        if(user != null){
            user = userRepository.save(user)
            return "${user.name} details has been updated"}
        else{
            return "Enter valid details"
        }
    }

    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getticketList(userUpdate: UserLoginDto): Any{
        val user1= userRepository.findByEmail(userUpdate.email)
        if (user1 != null) {
            return user1.ticketList
        }
        else{
            return "no tickets"
        }
    }



}