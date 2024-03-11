package com.fiap.parquimetro.model;

import lombok.Data;

@Data
public class Ticket {
    private User user;
    private InfoParking infoParking;
}
