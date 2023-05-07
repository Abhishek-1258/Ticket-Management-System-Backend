package com.sleevesup.TicketManagement.exceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun createTicketException(apiException: ApiException): ResponseEntity<String> {
        return ResponseEntity(apiException.message, HttpStatus.BAD_REQUEST)
    }
}