package com.fiap.parquimetro.service.Impl;

import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.repository.UserRepository;
import com.fiap.parquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getListUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserId(String id) {
        return this.userRepository.findById(id)
                                  .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }
    @Override
    public User calculateTimeUser() {
        return null;
    }

    @Override
    public User calculateTotalPriceUserWillPay() {
        return null;
    }

    @Override
    public User verifyPaymentWasApproved() {
        return null;
    }


}
