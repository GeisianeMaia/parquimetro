package com.fiap.parquimetro.dto;

import com.fiap.parquimetro.model.InfoParking;
import com.fiap.parquimetro.model.User;

public record TicketDTO(User user, InfoParking infoParking) {
}
