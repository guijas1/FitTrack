package com.guijas1.Fitrack.controller;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.service.RegistroFisicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/register")
public class RegistroController {

    private final RegistroFisicoService service;

    public RegistroController(RegistroFisicoService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<RegistroFisicoDTO> registro(RegistroFisicoDTO dto){
        service.register(dto);
        return ResponseEntity.ok(dto);
    }
}
