package com.example.clinica.dto.medico;

import com.example.clinica.domain.model.Medico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoResponseDTO {

    private Long id;
    private String nome;

    public MedicoResponseDTO toDto(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        return this;
    }

}
