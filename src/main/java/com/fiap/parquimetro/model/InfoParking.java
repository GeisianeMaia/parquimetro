package com.fiap.parquimetro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class InfoParking {
    @Id
    private String id;
    private Double time;
    private Double price;
}
