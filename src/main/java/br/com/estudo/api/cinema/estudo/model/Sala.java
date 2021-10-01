package br.com.estudo.api.cinema.estudo.model;

import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sala {

    private Long id;
    private int capacidade;

    public Sala(SalaEntity salaEntity) {
        this.id = salaEntity.getId();
        this.capacidade = salaEntity.getCapacidade();
    }
}

