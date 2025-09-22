package com.example.clinica.controller;


import com.example.clinica.dto.paciente.PacienteCreateDTO;
import com.example.clinica.dto.paciente.PacienteEditDto;
import com.example.clinica.dto.paciente.PacienteResponseDTO;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> save(@RequestBody PacienteCreateDTO dto) {
        return ResponseEntity.status(201).body(new PacienteResponseDTO().toDto(service.criar(dto)));
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteResponseDTO> findById(@PathVariable Long id) {
        return service.findById(id).map(paciente -> {
                    return new PacienteResponseDTO().toDto(paciente);
                }).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<PacienteResponseDTO> update(@PathVariable Long id,
                                                      @RequestBody PacienteEditDto dto) {
        return service.update(id, dto)
                .map(paciente -> new PacienteResponseDTO().toDto(paciente)
                ).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> findAll() {
        return ResponseEntity.ok(
                service
                        .findAll()
                        .stream()
                        .map(paciente -> {
                            return new PacienteResponseDTO().toDto(paciente);
                        })
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = service.delete(id);
        if (result) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
