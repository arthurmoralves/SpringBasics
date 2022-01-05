package br.com.estudo.api.cinema.estudo.dto;

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
