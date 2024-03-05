package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getListUsers(){
        return this.userService.getListUsers();
    }

    @GetMapping("/{id}")
    public User getUserId(@PathVariable String id){
        return this.userService.getUserId(id);
    }

    @PostMapping
    public User createTicket(@RequestBody User user){
        return this.userService.createUser(user);
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
