package com.fiap.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class User {
    @Id
    private String id;
    private String plateCar;
    private String time;
    private LocalDateTime startDateTime;
    private String paymentType;

    public User(String id, String plateCar, String time, LocalDateTime startDateTime, String paymentType) {
        this.id = id;
        this.plateCar = plateCar;
        this.time = time;
        this.startDateTime = startDateTime;
        this.paymentType = paymentType;
    }
}
