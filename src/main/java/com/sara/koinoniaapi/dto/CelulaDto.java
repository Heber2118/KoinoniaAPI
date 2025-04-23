package com.sara.koinoniaapi.dto;
import java.time.DayOfWeek;
import java.time.LocalTime;

public record CelulaDto(Long id, String nome, String endereco,
                        DayOfWeek diaSemana, LocalTime horario) {
}