package com.sara.koinoniaapi.dto;

import java.util.List;

public record CelulasLiderDto(
        Long id,
        String nome,
        String telefone,
        List<CelulaDto> celulas
) {}
