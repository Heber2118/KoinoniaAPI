package com.sara.koinoniaapi.model.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelulaLiderId implements Serializable {
    private Long celula;
    private Long lider;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CelulaLiderId that)) return false;
        return Objects.equals(celula, that.celula) && Objects.equals(lider, that.lider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(celula, lider);
    }

}
