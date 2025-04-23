package com.sara.koinoniaapi.service;

import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.repository.CelulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CelulaService {

    private final CelulaRepository celulaRepository;

    public List<CelulaDto> listarCelulas() {
        return celulaRepository.findAll().stream().map(celula -> new CelulaDto(celula.getId(),
                celula.getNome(),celula.getEndereco(),
                celula.getDiaSemana(),celula.getHorario())).toList();
    }

}
