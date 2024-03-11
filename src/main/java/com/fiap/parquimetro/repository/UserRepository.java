package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
