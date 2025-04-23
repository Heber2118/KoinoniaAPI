package com.sara.koinoniaapi.controller;

import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.dto.CelulasLiderDto;
import com.sara.koinoniaapi.dto.LiderDto;
import com.sara.koinoniaapi.repository.LiderRepository;
import com.sara.koinoniaapi.service.LiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lideres")
@RequiredArgsConstructor
public class LiderController {

    private final LiderService liderService;

    @GetMapping("/listar")
    public List<LiderDto> listarLideres(){
        return liderService.listarLiders();
    }

    @GetMapping("/{id}/celulas")
    public ResponseEntity<CelulasLiderDto> listarCelulasPorLider(@PathVariable Long id) {
        return liderService.listarCelulasPorLider(id);
    }

}
