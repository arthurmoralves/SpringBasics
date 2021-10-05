package br.com.estudo.api.cinema.estudo.dto;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessaoDto {

    private BigDecimal valor;
    private String titulo;

    public SessaoDto(SessaoEntity sessaoEntity) {
        this.valor = sessaoEntity.getValor();
        this.titulo = sessaoEntity.getTitulo();
    }
}