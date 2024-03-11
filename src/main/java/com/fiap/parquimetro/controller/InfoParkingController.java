package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.service.InfoParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info-parking")
public class InfoParkingController {
    private final InfoParkingService infoParkingService;

    @Autowired
    public InfoParkingController(InfoParkingService infoParkingService) {
        this.infoParkingService = infoParkingService;
    }

    @PostMapping("/calculatePrice")
    public ResponseEntity<InfoParkingDTO> calculateParkingPrice(@RequestBody InfoParkingDTO infoParkingDTO) {
        InfoParkingDTO calculatedInfoParkingDTO = infoParkingService.calculateParkingPrice(infoParkingDTO);
        return ResponseEntity.ok(calculatedInfoParkingDTO);
    }
}
