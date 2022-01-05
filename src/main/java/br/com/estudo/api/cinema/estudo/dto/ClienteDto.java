package br.com.estudo.api.cinema.estudo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ClienteDto {

    private Long id;
    private String CPF;
    private String nome;
    private String dataNasc;
}
