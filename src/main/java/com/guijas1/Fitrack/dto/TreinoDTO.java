package com.guijas1.Fitrack.dto;

import com.guijas1.Fitrack.entity.tipoEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TreinoDTO(
         @NotNull
         tipoEnum tipo,
         @NotNull
         @Positive
         Integer duracaoMinutos,
         Double caloriaGastas,
         LocalDateTime dataHora
) {
}
