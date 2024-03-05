package com.fiap.parquimetro.model;

import lombok.Data;
import lombok.Generated;
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
    private String totalPrice;
    private String paymentType;
}
