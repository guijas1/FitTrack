package com.guijas1.Fitrack.mapper;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import org.springframework.stereotype.Component;

@Component
public class TreinoMapper {

    public Treino toEntity(TreinoDTO dto){
        if(dto == null){
            return null;
        }
        Treino treino = new Treino();

        treino.setTreino(dto.treino());
        treino.setTipo(dto.tipo());
        treino.setDuracaoMinutos(dto.duracaoMinutos());
        treino.setCaloriaGastas(dto.caloriaGastas());
        treino.setDataHora(dto.dataHora());

        return treino;
    }

    public TreinoDTO toDTO(Treino treino){

        if(
                treino == null
        ){
            return null;
        }

        TreinoDTO dto = new TreinoDTO(
                treino.getTreino(),
                treino.getTipo(),
                treino.getDuracaoMinutos(),
                treino.getCaloriaGastas(),
                treino.getDataHora()
                );
        return dto;
    }

}
