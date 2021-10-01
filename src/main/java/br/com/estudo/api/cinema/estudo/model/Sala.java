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
    private Long idSessao;
    private String titulo;
    private Long idVenda;

    public Sala(SalaEntity salaEntity) {
        this.id = salaEntity.getId();
        this.idSessao = salaEntity.getSessao().getId();
        this.titulo = salaEntity.getSessao().getTitulo();
        this.idVenda = salaEntity.getVenda().getId();
    }
}

