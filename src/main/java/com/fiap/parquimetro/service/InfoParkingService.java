package com.fiap.parquimetro.service;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.model.InfoParking;

public interface InfoParkingService {
    public InfoParkingDTO calculateParkingPrice(InfoParkingDTO infoParkingDTO);

    public InfoParkingDTO toInfoParkingDTO (InfoParking infoParking);

    public InfoParking toInfoParking(InfoParkingDTO infoParkingDTO);
}
