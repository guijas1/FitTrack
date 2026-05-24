package com.guijas1.Fitrack.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TreinoDTO(
         @NotNull
         String tipo,
         Integer duracaoMinutos,
         Double caloriaGastas,
         LocalDateTime dataHora
) {
}
