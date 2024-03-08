package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.model.InfoParking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoParkingRepository extends MongoRepository<InfoParking, String> {
}
