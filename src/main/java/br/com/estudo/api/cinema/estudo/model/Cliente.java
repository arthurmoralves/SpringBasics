package br.com.estudo.api.cinema.estudo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    private String CPF;
    private String nome;
    private String dataNasc;
}
