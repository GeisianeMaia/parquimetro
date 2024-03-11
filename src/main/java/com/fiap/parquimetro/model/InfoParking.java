package com.fiap.parquimetro.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class InfoParking {
    @Id
    private String id;
    @NotBlank(message ="Preencha o campo.")
    private Double time;
    @NotBlank(message ="Preencha o campo.")
    private Double price;
}
