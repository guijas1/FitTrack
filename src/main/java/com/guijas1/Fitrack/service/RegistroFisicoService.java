package com.guijas1.Fitrack.service;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.entity.RegistroFisico;
import com.guijas1.Fitrack.exception.BadRequestException;
import com.guijas1.Fitrack.exception.FutureDateException;
import com.guijas1.Fitrack.mapper.RegistroFisicoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.UUID;

@Service
public class RegistroFisicoService {

    private final RegistroFisicoMapper mapper;

    public RegistroFisicoService(RegistroFisicoMapper mapper) {
        this.mapper = mapper;
    }

    List<RegistroFisico> ls = new ArrayList<>();

    public RegistroFisico register(RegistroFisicoDTO dto) {
        validate(dto);
        RegistroFisico registro = mapper.toEntity(dto);
        registro.setId(UUID.randomUUID().toString());
        ls.add(registro);
        return registro;
    }

    public List<RegistroFisico> listRegister(){
        if(ls.isEmpty()){
            throw new EmptyStackException();
        }
        return ls;
    }

    public RegistroFisicoDTO validate(RegistroFisicoDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Payload vazio", HttpStatus.BAD_REQUEST);
        }

        if (dto.dataRegistro() == null) {
            throw new BadRequestException("Data de registro é obrigatória", HttpStatus.BAD_REQUEST);
        }

        if (dto.dataRegistro().isAfter(LocalDate.now())) {
            throw new FutureDateException(
                    "Data de registro não pode ser no futuro",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        if (dto.peso() == null || dto.altura() == null) {
            throw new BadRequestException("Peso e altura são obrigatórios", HttpStatus.BAD_REQUEST);
        }

        if ((dto.peso() <= 10 || dto.peso() >= 500) ||
                (dto.altura() <= 50 || dto.altura() >= 230.00)) {
            throw new BadRequestException("Peso ou altura inválidos", HttpStatus.BAD_REQUEST);
        }

        return dto;
    }
}