package com.guijas1.Fitrack.service;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import com.guijas1.Fitrack.exception.BadRequestException;
import com.guijas1.Fitrack.mapper.TreinoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {

    private final TreinoMapper mapper;

    public TreinoService(TreinoMapper mapper){
        this.mapper = mapper;
    }

    public Treino createTreino(TreinoDTO dto){

        return treino;
    }

    public void ValidTreino(TreinoDTO dto){
        if(dto == null){
            throw new BadRequestException("TREINO INVALIDO", HttpStatus.BAD_REQUEST);
        }
        if(dto )
    }

}
