package com.fiap.parquimetro.dto;

import java.time.LocalDateTime;

public record UserDTO(String id, String time, String plateCar, LocalDateTime startDateTime, String paymentType) {

}
