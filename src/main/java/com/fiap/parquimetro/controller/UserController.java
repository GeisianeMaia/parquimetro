package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO> getListUsers(){
        return this.userService.getListUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserId(@PathVariable String id){
        return this.userService.getUserId(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return this.userService.createUser(userDTO);
    }

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
