package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.dto.TicketDTO;
import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.service.InfoParkingService;
import com.fiap.parquimetro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<UserDTO> getListUsers() {
        return this.userService.getListUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserId(@PathVariable String id) {
        return this.userService.getUserId(id);
    }

    @PostMapping
    public ResponseEntity<?> createUserInfoParking(@Valid @RequestBody TicketDTO request) {

        UserDTO userDTO = new UserDTO(
                null,
                request.user().getPlateCar(),
                request.user().getStartDateTime(),
                null

        );
        InfoParkingDTO infoParkingDTO = new InfoParkingDTO(
                null,
                request.infoParking().getTime(),
                request.infoParking().getPrice()
        );
        return this.userService.createUserInfoParking(userDTO, infoParkingDTO);
    }
}
