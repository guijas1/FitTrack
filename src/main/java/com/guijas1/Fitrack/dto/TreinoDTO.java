package com.guijas1.Fitrack.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TreinoDTO(
         String treino,
         String tipo,
         Integer duracaoMinutos,
         Double caloriaGastas,
         LocalDateTime dataHora
) {
}
