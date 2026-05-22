package com.guijas1.Fitrack.controller;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.service.RegistroFisicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistroController {

    private final RegistroFisicoService service;

    public RegistroController(RegistroFisicoService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<RegistroFisicoDTO> registro(@RequestBody @Valid RegistroFisicoDTO dto){
        service.register(dto);
        return ResponseEntity.ok(dto);
    }
}
