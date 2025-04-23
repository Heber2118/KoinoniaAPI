package com.sara.koinoniaapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private DayOfWeek diaSemana;
    private LocalTime horario;

    @ManyToMany
    @JoinTable(
            name = "celula_lider",
            joinColumns = @JoinColumn(name = "celula_id"),
            inverseJoinColumns = @JoinColumn(name = "lider_id")
    )
    private List<Lider> lideres = new ArrayList<>();

}
