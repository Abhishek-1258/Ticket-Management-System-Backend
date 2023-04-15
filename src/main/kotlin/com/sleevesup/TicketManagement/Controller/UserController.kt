package com.sleevesup.TicketManagement.Controller

import com.sleevesup.TicketManagement.DTO.UserLoginDto
import com.sleevesup.TicketManagement.Service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("api/v1")
class UserController(private val userService: UserService) {

    @PostMapping("create-user")
    fun createUser(@RequestBody userInfo:UserLoginDto): ResponseEntity<Any>{
        val result = userService.createUser(userInfo)
        return ResponseEntity.ok(result)
    }

    @PutMapping("/update/{id}")
    fun updateUser(@RequestBody userUpdate: UserLoginDto,@PathVariable id:Int): ResponseEntity<Any> {
        val result = userService.updateUser(userUpdate,id)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/get-users")
    fun getUsers(): ResponseEntity<Any> {
        val result = userService.getUsers()
        return ResponseEntity.ok(result)
    }

}