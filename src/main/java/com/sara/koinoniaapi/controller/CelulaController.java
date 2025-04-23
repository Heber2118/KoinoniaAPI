package com.sara.koinoniaapi.controller;

import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.model.Celula;
import com.sara.koinoniaapi.repository.CelulaRepository;
import com.sara.koinoniaapi.service.CelulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/celulas")
@RequiredArgsConstructor
public class CelulaController {


  private final CelulaService celulaService;

    @GetMapping("/listar")
    public List<CelulaDto> listarCelulas() {
        return celulaService.listarCelulas();
    }

}


