package com.sara.koinoniaapi.service;

import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.dto.CelulasLiderDto;
import com.sara.koinoniaapi.dto.LiderDto;
import com.sara.koinoniaapi.repository.LiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LiderService {

    private final LiderRepository liderRepository;

    public List<LiderDto> listarLiders() {
        return liderRepository.findAll().stream().map(
                lider -> new LiderDto(lider.getId(), lider.getNome(),
                        lider.getTelefone(), lider.getEmail(), lider.isAtivo())).toList();
    }

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
