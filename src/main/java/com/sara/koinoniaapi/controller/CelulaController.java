package com.sara.koinoniaapi.controller;

import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.model.Celula;
import com.sara.koinoniaapi.repository.CelulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/celulas")
@RequiredArgsConstructor
public class CelulaController {

    private final CelulaRepository celulaRepository;

    @GetMapping("/listar")
    public List<CelulaDto> listarCelulas() {
        return celulaRepository.findAll().stream().map(celula -> new CelulaDto(celula.getId(),
                celula.getNome(),celula.getEndereco(),
                celula.getDiaSemana(),celula.getHorario())).toList();
    }

}


