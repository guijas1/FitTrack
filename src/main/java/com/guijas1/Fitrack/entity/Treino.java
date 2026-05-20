package com.guijas1.Fitrack.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Treino {

    private String treino;
    private String tipo;
    private Integer duracaoMinutos;
    private Double caloriaGastas;
    private LocalDateTime dataHora;
}
