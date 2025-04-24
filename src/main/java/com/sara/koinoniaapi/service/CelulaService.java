package com.sara.koinoniaapi.service;

import com.sara.koinoniaapi.dto.AssociarLiderDto;
import com.sara.koinoniaapi.dto.CelulaDto;
import com.sara.koinoniaapi.dto.CelulasLiderDto;
import com.sara.koinoniaapi.model.Celula;
import com.sara.koinoniaapi.model.CelulaLider;
import com.sara.koinoniaapi.model.Lider;
import com.sara.koinoniaapi.repository.CelulaLiderRepository;
import com.sara.koinoniaapi.repository.CelulaRepository;
import com.sara.koinoniaapi.repository.LiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CelulaService {

    private final CelulaRepository celulaRepository;
    private final LiderRepository liderRepository;
    private final CelulaLiderRepository celulaLiderRepository;

    public List<CelulaDto> listarCelulas() {
        return celulaRepository.findAll().stream().map(celula -> new CelulaDto(celula.getId(),
                celula.getNome(),celula.getEndereco(),
                celula.getDiaSemana(),celula.getHorario())).toList();
    }
    public CelulaDto cadastrarCelula(CelulaDto celulaDto) {
        Celula nova = new Celula(null, celulaDto.nome(), celulaDto.endereco(),
                celulaDto.diaSemana(), celulaDto.horario(), new ArrayList<>());
        Celula salva = celulaRepository.save(nova);
        return new CelulaDto(salva.getId(),salva.getNome(),salva.getEndereco(),salva.getDiaSemana(),salva.getHorario());
    }

    public Lider relacionarCelula(Long liderId, AssociarLiderDto dto) {
        Lider lider = liderRepository.findById(liderId).orElseThrow(()
                -> new RuntimeException("Líder não encontrado na base de dados!"));

        Celula celula = celulaRepository.findById(dto.celulaId())
                .orElseThrow(() -> new RuntimeException("Célula não encontrada na base de dados!"));

        if (celulaLiderRepository.existsByCelula(celula)) {
            throw new RuntimeException("Essa célula já está associada a um líder.");
        }

        CelulaLider celulaLider = new CelulaLider(celula, lider);
        celulaLiderRepository.save(celulaLider);
        return lider;
    }

    public CelulaDto atualizarCelula(Long id, CelulaDto celulaDto) {
       Celula celula = celulaRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Célula não encontrada na base de dados!"));

               celula.setNome(celulaDto.nome());
               celula.setEndereco(celulaDto.endereco());
               celula.setDiaSemana(celulaDto.diaSemana());
               celula.setHorario(celulaDto.horario());

               Celula salva = celulaRepository.save(celula);
               return new CelulaDto(
                       salva.getId(),
                       salva.getNome(),
                       salva.getEndereco(),
                       salva.getDiaSemana(),
                       salva.getHorario()
               );

    }

}
