package com.fiap.parquimetro.dto;

import com.fiap.parquimetro.model.InfoParking;

import java.time.LocalDateTime;

public record UserDTO(String id, String plateCar, LocalDateTime startDateTime, InfoParking infoParking
) {

}
