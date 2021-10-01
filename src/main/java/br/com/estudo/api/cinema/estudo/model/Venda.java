package br.com.estudo.api.cinema.estudo.model;

import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import br.com.estudo.api.cinema.estudo.mapper.SessaoMapper;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Venda {

    private String titulo;
    private String cliente;
    private Long sala;

    public Venda(VendaEntity vendaEntity) {
        this.titulo = vendaEntity.getSessao().getTitulo();
        this.cliente = vendaEntity.getCliente().getNome();
        this.sala = vendaEntity.getSala().getId();
    }
}
