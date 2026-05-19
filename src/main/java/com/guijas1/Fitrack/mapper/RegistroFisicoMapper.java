package com.guijas1.Fitrack.mapper;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.entity.RegistroFisico;
import org.springframework.stereotype.Component;

@Component
public class RegistroFisicoMapper {

    public RegistroFisico toEntity(RegistroFisicoDTO dto) {
        if (dto == null) {
            return null;
        }

        RegistroFisico entidade = new RegistroFisico();

        entidade.setId(dto.id());
        entidade.setAltura(dto.altura());
        entidade.setPeso(dto.peso());
        entidade.setDataRegistro(dto.dataRegistro());
        entidade.setCircunferenciaAbdominal(dto.circunferenciaAbdominal());

        return entidade;
    }

    public RegistroFisicoDTO toDto(RegistroFisico entidade) {
        if (entidade == null) {
            return null;
        }

        return new RegistroFisicoDTO(
                entidade.getId(),
                entidade.getPeso(),
                entidade.getAltura(),
                entidade.getCircunferenciaAbdominal(),
                entidade.getDataRegistro()
        );
    }
}