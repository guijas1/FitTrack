package com.guijas1.Fitrack.service;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.entity.RegistroFisico;
import com.guijas1.Fitrack.mapper.RegistroFisicoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegistroFisicoService {

    private final RegistroFisicoMapper mapper;

    public RegistroFisicoService(RegistroFisicoMapper mapper) {
        this.mapper = mapper;
    }

    public RegistroFisico register(RegistroFisicoDTO dto){
        if(dto == null){
            throw new IllegalArgumentException("Payload veio vazio!");
        }
        HttpStatus status = HttpStatus.CREATED;
        return mapper.toEntity(dto);

    }


    public

}
