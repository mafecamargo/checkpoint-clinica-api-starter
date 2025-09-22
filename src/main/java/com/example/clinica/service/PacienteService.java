package com.example.clinica.service;


import com.example.clinica.domain.model.Paciente;
import com.example.clinica.dto.paciente.PacienteCreateDTO;
import com.example.clinica.dto.paciente.PacienteEditDto;
import com.example.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente criar(PacienteCreateDTO dto) {
        Paciente p = new Paciente();

        p.setCpf(dto.cpf());
        p.setEmail(dto.email());
        p.setNome(dto.nome());
        return repository.save(p);
    }

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Paciente> update(Long id,  PacienteEditDto dto) {
        return repository.findById(id)
                .map(paciente -> {
                    if (dto.getNome()!=null) {
                        paciente.setNome(dto.getNome());
                    }
                    if(dto.getEmail()!=null) {
                        paciente.setEmail(dto.getEmail());
                    }
                    return repository.save(paciente);
                });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
