package br.com.estudo.api.cinema.estudo.model;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sessao {

    private BigDecimal valor;
    private String titulo;

    public Sessao(SessaoEntity sessaoEntity) {
        this.valor = sessaoEntity.getValor();
        this.titulo = sessaoEntity.getTitulo();
    }
}
