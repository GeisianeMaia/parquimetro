package com.fiap.parquimetro.service.Impl;

import com.fiap.parquimetro.dto.InfoParkingDTO;
import com.fiap.parquimetro.dto.UserDTO;
import com.fiap.parquimetro.model.InfoParking;
import com.fiap.parquimetro.model.User;
import com.fiap.parquimetro.repository.InfoParkingRepository;
import com.fiap.parquimetro.repository.UserRepository;
import com.fiap.parquimetro.service.InfoParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoParkingServiceImpl implements InfoParkingService {
    @Autowired
    private InfoParkingRepository infoParkingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public InfoParkingDTO calculateParkingPrice(InfoParkingDTO infoParkingDTO){
        double price;

        if (infoParkingDTO.time() <= 30) {
            price = 0.90;
        } else if (infoParkingDTO.time() <= 60) {
            price = 1.65;
        } else if (infoParkingDTO.time() <= 120) {
            price = 2.65;
        } else {
            price = 2.65 + Math.ceil((infoParkingDTO.time() - 120) / 60.0) * 1.00;
        }

        return new InfoParkingDTO(infoParkingDTO.id(), infoParkingDTO.time(), price);
    }

    @Override
    public InfoParkingDTO toInfoParkingDTO(InfoParking infoParking) {
        return new InfoParkingDTO(
                infoParking.getId(),
                infoParking.getTime(),
                infoParking.getPrice()
        );
    }

    @Override
    public InfoParking toInfoParking(InfoParkingDTO infoParkingDTO) {
        return new InfoParking();
    }


}
