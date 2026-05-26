package com.guijas1.Fitrack.service;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import com.guijas1.Fitrack.entity.tipoEnum;
import com.guijas1.Fitrack.exception.BadRequestException;
import com.guijas1.Fitrack.exception.FutureDateException;
import com.guijas1.Fitrack.mapper.TreinoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class TreinoService {

    private final TreinoMapper mapper;

    public TreinoService(TreinoMapper mapper){
        this.mapper = mapper;
    }

    public Treino createTreino(TreinoDTO dto){
        validTreino(dto);
        Treino treino = mapper.toEntity(dto);
        treino.setUsuarioId(UUID.randomUUID().toString());
        return treino;
    }

    public TreinoDTO validTreino(TreinoDTO dto){

        if(dto == null){
            throw new BadRequestException("TREINO INVALIDO", HttpStatus.BAD_REQUEST);
        }
        if(dto.duracaoMinutos() < 1){
            throw new BadRequestException("Training time not valid, less than 0", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(dto.caloriaGastas() < 0){
            throw new BadRequestException("Kcal lost less equas or less than 0", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(dto.dataHora().isAfter(LocalDateTime.now())){
            throw new FutureDateException("The inputed time was in future.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return dto;

    }

}
