package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.dto.TicketDTO;
import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.InfoParking;
import com.fiap.parquimetro.model.Ticket;
import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.service.InfoParkingService;
import com.fiap.parquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    private InfoParkingService infoParkingService;
    @Autowired
    public UserController(UserService userService, InfoParkingService infoParkingService) {
        this.userService = userService;
        this.infoParkingService = infoParkingService;
    }

    @GetMapping
    public List<UserDTO> getListUsers(){
        return this.userService.getListUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserId(@PathVariable String id){
        return this.userService.getUserId(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    @PostMapping
//    public ResponseEntity<UserDTO> createUser(@RequestBody TicketDTO objRequest) {
//
//        UserDTO userDTO = objRequest.userDTO();
//        InfoParkingDTO infoParkingDTO = objRequest.infoParkingDTO();
//        return this.userService.createUser(userDTO, infoParkingDTO);
//    }

    public User calculateTimeUser(){
        return null;
    }

    public User calculateTotalPriceUserWillPay(){
        return null;
    }

    public User verifyPaymentWasApproved(){
        return null;
    }
}
