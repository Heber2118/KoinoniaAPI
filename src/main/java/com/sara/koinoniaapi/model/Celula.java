package com.sara.koinoniaapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Celula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String diaSemana;
    private String horario;

    @ManyToMany
    @JoinTable(
            name = "celula_lider",
            joinColumns = @JoinColumn(name = "celula_id"),
            inverseJoinColumns = @JoinColumn(name = "lider_id")
    )
    private List<Lider> lideres = new ArrayList<>();

}
