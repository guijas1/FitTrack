package com.guijas1.Fitrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record RegistroFisicoDTO(

         @NotNull
         @Positive(message = "O valor do peso deve ser positivo.")
         Double peso,
         @Positive(message = "O valor da altura deve ser positivo.")
         @NotNull
         Double altura,
         @Positive(message = "O valor da Circunferencia abdominal deve ser positivo.")
         @NotNull
         Double circunferenciaAbdominal,

         LocalDate dataRegistro
) {



}
