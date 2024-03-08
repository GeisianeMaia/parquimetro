package com.fiap.parquimetro.service.Impl;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.InfoParking;
import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.repository.UserRepository;
import com.fiap.parquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getListUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserId(String id) {
        return toUserDTO(this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado")));
    }

    //    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        User user = toUser(userDTO);
//        User savedUser = this.userRepository.save(user);
//        return toUserDTO(savedUser);
//    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(
                userDTO.id(),
                userDTO.plateCar(),
                userDTO.startDateTime(),
                userDTO.infoParking()
        );

        user = userRepository.save(user);

        UserDTO createdUserDTO = new UserDTO(
                user.getId(),
                userDTO.plateCar(),
                userDTO.startDateTime(),
                userDTO.infoParking()
        );
        return createdUserDTO;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getPlateCar(),
                user.getStartDateTime(),
                user.getInfoParking()
        );
    }

    @Override
    public User toUser(UserDTO userDTO) {
        return new User(
                userDTO.id(),
                userDTO.plateCar(),
                LocalDateTime.now(),
                userDTO.infoParking()
        );
    }


}
