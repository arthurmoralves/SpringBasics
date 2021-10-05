package br.com.estudo.api.cinema.estudo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {

    private String CPF;
    private String nome;
    private String dataNasc;
}
