package com.sara.koinoniaapi.controller;

import com.sara.koinoniaapi.dto.AssociarLiderDto;
import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.dto.CelulasLiderDto;
import com.sara.koinoniaapi.model.Celula;
import com.sara.koinoniaapi.model.Lider;
import com.sara.koinoniaapi.repository.CelulaRepository;
import com.sara.koinoniaapi.service.CelulaService;
import com.sara.koinoniaapi.service.LiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/cadastrar")
    public CelulaDto cadastrarCelula(@RequestBody CelulaDto celulaDto) {
        return celulaService.cadastrarCelula(celulaDto);
    }

    @PostMapping("/relacionar")
    public ResponseEntity<Lider> relacionarLider(
            @RequestParam Long liderId,
            @RequestBody AssociarLiderDto dto) {
        celulaService.relacionarCelula(liderId, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CelulaDto> atualizarCelula(@PathVariable Long id, @RequestBody CelulaDto celulaDto) {
        CelulaDto atualizada = celulaService.atualizarCelula(id, celulaDto);
        return ResponseEntity.ok().body(atualizada);
    }

}


