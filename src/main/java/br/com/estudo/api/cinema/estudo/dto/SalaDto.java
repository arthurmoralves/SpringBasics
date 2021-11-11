package br.com.estudo.api.cinema.estudo.dto;

import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class SalaDto {

    private Long id;
    private int capacidade;

    public SalaDto(SalaEntity salaEntity) {
        this.id = salaEntity.getId();
        this.capacidade = salaEntity.getCapacidade();
    }
}

