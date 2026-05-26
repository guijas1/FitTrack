package com.guijas1.Fitrack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Treino {

    private String usuarioId;
    @Enumerated(EnumType.STRING)
    private tipoEnum tipo;
    private Integer duracaoMinutos;
    private Double caloriaGastas;
    private LocalDateTime dataHora;
}
