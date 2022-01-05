package br.com.estudo.api.cinema.estudo.dto;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class VendaDto {

    private String cliente;
    private List<SessaoEntity> sessao;

    public VendaDto(VendaEntity vendaEntity) {
        this.cliente = vendaEntity.getCliente().getCPF();
        this.sessao = vendaEntity.getSessao();
    }
}
