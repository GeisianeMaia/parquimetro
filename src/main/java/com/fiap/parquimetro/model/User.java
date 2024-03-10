package com.fiap.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class User {
    @Id
    private String id;
    private String plateCar;
    private LocalDateTime startDateTime;
    @DBRef
    private InfoParking infoParking;

    public User(String id, String plateCar, LocalDateTime startDateTime, InfoParking infoParking) {
        this.id = id;
        this.plateCar = plateCar;
        this.startDateTime = startDateTime;
        this.infoParking = infoParking;
    }

}
