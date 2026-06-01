package com.guijas1.Fitrack.mapper;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import org.springframework.stereotype.Component;

@Component
public class TreinoMapper {

    public Treino toEntity(TreinoDTO dto) {
        if (dto == null) {
            return null;
        }

        Treino treino = new Treino();

        treino.setTipo(dto.tipo());
        treino.setDuracaoMinutos(dto.duracaoMinutos());
        treino.setCaloriasGastas(dto.caloriasGastas());
        treino.setDataHora(dto.dataHora());

        return treino;
    }

    public TreinoDTO toDTO(Treino treino) {
        if (treino == null) {
            return null;
        }

        return new TreinoDTO(
                treino.getTipo(),
                treino.getDuracaoMinutos(),
                treino.getCaloriasGastas(),
                treino.getDataHora()
        );
    }
}