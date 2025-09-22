package com.example.clinica.service;


import com.example.clinica.domain.model.Consulta;
import com.example.clinica.domain.model.Medico;
import com.example.clinica.domain.model.Paciente;
import com.example.clinica.dto.consulta.ConsultaCreateDTO;
import com.example.clinica.repository.ConsultaRepository;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConsultaService {

    @Autowired
    public ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    public Consulta criarConsulta(ConsultaCreateDTO dto) {
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return consultaRepository.save(new Consulta(medico, paciente));
    }

}
