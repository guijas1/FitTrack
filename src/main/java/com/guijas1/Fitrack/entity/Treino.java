package com.guijas1.Fitrack.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Treino {

    private String id;
    private String usuarioId;
    private String tipo;
    private Integer duracaoMinutos;
    private Double caloriasGastas;
    private LocalDateTime dataHora;
}