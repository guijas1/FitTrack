package com.guijas1.Fitrack.service;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import com.guijas1.Fitrack.exception.BadRequestException;
import com.guijas1.Fitrack.exception.FutureDateException;
import com.guijas1.Fitrack.mapper.TreinoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class TreinoService {

    private final TreinoMapper mapper;

    private final List<Treino> treinos = new ArrayList<>();

    private static final Set<String> TIPOS_ACEITOS = Set.of(
            "MUSCULACAO",
            "CORRIDA",
            "NATACAO",
            "YOGA",
            "CICLISMO",
            "FUNCIONAL"
    );

    public TreinoService(TreinoMapper mapper) {
        this.mapper = mapper;
    }

    public Treino createTreino(TreinoDTO dto) {
        validateTreino(dto);

        Treino treino = mapper.toEntity(dto);
        treino.setID(UUID.randomUUID().toString());

        treinos.add(treino);

        return treino;
    }

    public TreinoDTO validateTreino(TreinoDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Payload vazio", HttpStatus.BAD_REQUEST);
        }

        if (dto.tipo() == null || dto.tipo().isBlank()) {
            throw new BadRequestException(
                    "Tipo de treino é obrigatório",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        String tipoNormalizado = dto.tipo().trim().toUpperCase();

        if (!TIPOS_ACEITOS.contains(tipoNormalizado)) {
            throw new BadRequestException(
                    "Tipo de treino inválido. Valores aceitos: MUSCULACAO, CORRIDA, NATACAO, YOGA, CICLISMO, FUNCIONAL",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        if (dto.duracaoMinutos() == null || dto.duracaoMinutos() <= 0) {
            throw new BadRequestException(
                    "Duração do treino deve ser maior que zero",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        if (dto.caloriaGastas() == null || dto.caloriaGastas() < 0) {
            throw new BadRequestException(
                    "Calorias gastas não podem ser negativas",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        if (dto.dataHora() == null) {
            throw new BadRequestException(
                    "Data e hora do treino são obrigatórias",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        if (dto.dataHora().isAfter(LocalDateTime.now())) {
            throw new FutureDateException(
                    "Data e hora do treino não podem ser no futuro",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }

        return dto;
    }

    public List<Treino> listTreinos() {
        return treinos;
    }
}