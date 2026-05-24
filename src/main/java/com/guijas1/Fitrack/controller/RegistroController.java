package com.guijas1.Fitrack.controller;

import com.guijas1.Fitrack.dto.RegistroFisicoDTO;
import com.guijas1.Fitrack.entity.RegistroFisico;
import com.guijas1.Fitrack.service.RegistroFisicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity<List<RegistroFisico>> listALl(){
        return ResponseEntity.ok(service.listRegister());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<RegistroFisico> findById(@RequestBody @PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }
    
}
