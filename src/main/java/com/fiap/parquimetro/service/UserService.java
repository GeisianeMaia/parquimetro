package com.fiap.parquimetro.service;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public List<UserDTO> getListUsers();

    public UserDTO getUserId(String id);

    public ResponseEntity<?> createUserInfoParking(UserDTO userDTO, InfoParkingDTO infoParkingDTO);
    public UserDTO toUserDTO (User user);

    public User toUser(UserDTO userDTO);



}
