package com.sara.koinoniaapi.controller;

import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.dto.CelulasLiderDto;
import com.sara.koinoniaapi.dto.LiderDto;
import com.sara.koinoniaapi.repository.LiderRepository;
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

    private final LiderRepository liderRepository;

    @GetMapping("/listar")
    public List<LiderDto> listarLideres(){
        return liderRepository.findAll().stream().map(
                lider -> new LiderDto(lider.getId(), lider.getNome(),
                lider.getTelefone(), lider.getEmail(), lider.isAtivo())).toList();
    }

    @GetMapping("/{id}/celulas")
    public ResponseEntity<CelulasLiderDto> listarCelulasPorLider(@PathVariable Long id) {
        return liderRepository.findById(id)
                .map(lider -> {
                    List<CelulaDto> celulas = lider.getCelulas().stream()
                            .map(c -> new CelulaDto(
                                    c.getId(), c.getNome(), c.getEndereco(),
                                    c.getDiaSemana(), c.getHorario()))
                            .toList();

                    CelulasLiderDto dto = new CelulasLiderDto(
                            lider.getId(), lider.getNome(), lider.getTelefone(), celulas);

                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
