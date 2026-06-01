package com.guijas1.Fitrack.dto;

import java.time.LocalDateTime;

public record TreinoDTO(
        String tipo,
        Integer duracaoMinutos,
        Double caloriasGastas,
        LocalDateTime dataHora
) {
}