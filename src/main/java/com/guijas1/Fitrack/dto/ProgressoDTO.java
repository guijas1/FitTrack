package com.guijas1.Fitrack.dto;

public record ProgressoDTO(

         String usuarioId,
         Double IMC,
         String Progresso,
         Double pesoInicial,
         Double pesoAtual,
         Double variacaoPeso,
         Integer totalTreinos,
         Double totalCaloriasGastas,
         Double mediaDuracaoTreino
) {
}
