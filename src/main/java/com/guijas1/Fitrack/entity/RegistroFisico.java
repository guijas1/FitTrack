package com.guijas1.Fitrack.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class RegistroFisico {

    private String id;
    private Double peso;
    private Double altura;
    private Double circunferenciaAbdominal;
    private LocalDate dataRegistro;

}
