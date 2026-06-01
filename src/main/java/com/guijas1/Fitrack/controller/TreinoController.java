package com.guijas1.Fitrack.controller;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import com.guijas1.Fitrack.service.TreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("treino")
public class TreinoController {

    private final TreinoService service;

    public TreinoController(TreinoService service){
        this.service = service;
    }

    public ResponseEntity<Treino> createTreino(@RequestBody @Validated TreinoDTO dto){
        return ResponseEntity.ok(service.createTreino(dto));
    }
}
