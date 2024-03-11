package com.fiap.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Document
@Data
public class User {
    @Id
    private String id;

    @NotBlank(message = "A placa do carro não pode estar em branco.")
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
