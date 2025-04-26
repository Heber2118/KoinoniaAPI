package com.sara.koinoniaapi.repository;

import com.sara.koinoniaapi.model.Celula;
import com.sara.koinoniaapi.model.CelulaLider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CelulaLiderRepository extends JpaRepository<CelulaLider, Long> {
    boolean existsByCelula(Celula celula);

    Optional<CelulaLider> findByCelulaIdAndLiderId(Long celulaId, Long liderId);
}
