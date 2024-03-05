package com.fiap.parquimetro.service;

import com.fiap.parquimetro.model.User;

import java.util.List;

public interface UserService {

    public List<User> getListUsers();

    public User getUserId(String id);

    public User createUser( User user);

    public User calculateTimeUser();

    public User calculateTotalPriceUserWillPay();

    public User verifyPaymentWasApproved();

}
