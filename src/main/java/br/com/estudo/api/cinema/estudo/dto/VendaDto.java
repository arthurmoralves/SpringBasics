package br.com.estudo.api.cinema.estudo.dto;

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

    private ClienteDto cliente;
    private List<SessaoDto> sessoes;

}
