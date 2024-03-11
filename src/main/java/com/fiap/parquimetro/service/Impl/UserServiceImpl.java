package com.fiap.parquimetro.service.Impl;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.InfoParking;
import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.repository.InfoParkingRepository;
import com.fiap.parquimetro.repository.UserRepository;
import com.fiap.parquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InfoParkingRepository infoParkingRepository;

    @Autowired
    private InfoParkingServiceImpl infoParkingServiceImpl;
    @Autowired
    private MongoTransactionManager transactionManager;

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

     @Override
    public ResponseEntity<?> createUserInfoParking(UserDTO userDTO, InfoParkingDTO infoParkingDTO) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            try {
                User user = toUser(userDTO);
                userRepository.save(user);
                InfoParking infoParking = infoParkingServiceImpl.toInfoParking(infoParkingDTO);
                user.setInfoParking(infoParking);
                infoParkingRepository.save(infoParking);

                double timeInHours = infoParkingDTO.time();
                Duration duration = Duration.ofMinutes(Math.round(timeInHours * 60));
                user.setFinishDateTime(user.getStartDateTime().plus(duration));

                userRepository.save(user);
            } catch (Exception e) {
                status.setRollbackOnly();
                throw new RuntimeException("Erro ao criar usuário!" + e.getMessage());
            }
            return null;
        });
        return null;
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
