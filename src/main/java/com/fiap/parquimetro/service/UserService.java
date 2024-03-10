package com.fiap.parquimetro.service;

import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.InfoParking;
import com.fiap.parquimetro.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public List<UserDTO> getListUsers();

    public UserDTO getUserId(String id);

//    public UserDTO createUser(UserDTO userDTO);

    public ResponseEntity<?> createUser(UserDTO userDTO, InfoParking infoParking);
    public UserDTO toUserDTO (User user);

    public User toUser(UserDTO userDTO);



}
