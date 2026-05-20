package com.guijas1.Fitrack.service;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.entity.RegistroFisico;
import com.guijas1.Fitrack.exception.FutureDateException;
import com.guijas1.Fitrack.mapper.RegistroFisicoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class RegistroFisicoService {

    private final RegistroFisicoMapper mapper;

    public RegistroFisicoService(RegistroFisicoMapper mapper) {
        this.mapper = mapper;
    }

    public RegistroFisico register(RegistroFisicoDTO dto){
        validate(dto);
        HttpStatus status = HttpStatus.CREATED;
        return mapper.toEntity(dto);

    }
    public RegistroFisicoDTO validate(RegistroFisicoDTO dto){
        if(dto == null){
            HttpStatus status = HttpStatus.BAD_REQUEST;
            throw new IllegalArgumentException("Payload vazio");
        }
        if(dto.dataRegistro().isAfter(LocalDate.now())){
            throw new FutureDateException("Data de registro não podem ser no futuro", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if((dto.peso() <= 10 || dto.peso() >= 500) || (dto.altura() <= 50  || dto.altura() >= 230.00) ){
            throw new IllegalArgumentException("Peso ou altura inválidados");
        }
        return dto;
    }
    public String generateId(){
        UUID.randomUUID();

        return String st;
    }


}
