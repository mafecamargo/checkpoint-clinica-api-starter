package com.example.clinica.controller;

import com.example.clinica.dto.consulta.ConsultaCreateDTO;
import com.example.clinica.dto.consulta.ConsultaResponseDTO;
import com.example.clinica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService service;

    @PostMapping("/novaConsulta")
    public ResponseEntity<ConsultaResponseDTO> novaConsulta(@RequestBody ConsultaCreateDTO dto){
        return ResponseEntity.status(201).body(new ConsultaResponseDTO().toDto(service.criarConsulta(dto)));
    }

}
