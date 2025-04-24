package com.sara.koinoniaapi.controller;

import com.sara.koinoniaapi.dto.CelulasLiderDto;
import com.sara.koinoniaapi.dto.LiderDto;
import com.sara.koinoniaapi.service.LiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<LiderDto> atualizarLideres(@PathVariable Long id, @RequestBody LiderDto liderDto) {
        LiderDto liderAtualizado = liderService.atualizarLider(id, liderDto);
        return ResponseEntity.ok().body(liderAtualizado);
    }

}
