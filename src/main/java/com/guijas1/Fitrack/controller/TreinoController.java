package com.guijas1.Fitrack.controller;

import com.guijas1.Fitrack.dto.TreinoDTO;
import com.guijas1.Fitrack.entity.Treino;
import com.guijas1.Fitrack.service.TreinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    private final TreinoService service;

    public TreinoController(TreinoService service){
        this.service = service;
    }

    @PostMapping("/usuarios/{usuarioId}/treinos")
    public ResponseEntity<Treino> createTreino(
            @PathVariable String usuarioId,
            @RequestBody TreinoDTO dto
    ) {
        Treino treino = service.createTreino(usuarioId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(treino);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Treino>> listAll(){
        return ResponseEntity.ok(service.listTreinos());
    }
}
