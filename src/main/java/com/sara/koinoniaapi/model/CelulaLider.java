package com.sara.koinoniaapi.model;

import com.sara.koinoniaapi.model.id.CelulaLiderId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@IdClass(CelulaLiderId.class)  // Usar @IdClass para chave composta
public class CelulaLider {

    @Id
    @ManyToOne
    @JoinColumn(name = "celula_id")  // Referência para a célula
    private Celula celula;

    @Id
    @ManyToOne
    @JoinColumn(name = "lider_id")  // Referência para o líder
    private Lider lider;

    public CelulaLider(Celula celula, Lider lider) {
        this.celula = celula;
        this.lider = lider;
    }
}
