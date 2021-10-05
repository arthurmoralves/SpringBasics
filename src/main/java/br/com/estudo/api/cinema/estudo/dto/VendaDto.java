package br.com.estudo.api.cinema.estudo.dto;

import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class VendaDto {

    private String titulo;
    private String cliente;
    private Long sala;

    public VendaDto(VendaEntity vendaEntity) {
        this.titulo = vendaEntity.getSessao().getTitulo();
        this.cliente = vendaEntity.getCliente().getNome();
        this.sala = vendaEntity.getSala().getId();
    }
}
