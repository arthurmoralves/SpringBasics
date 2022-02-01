package br.com.estudo.api.cinema.estudo.dto;

import lombok.*;

import javax.persistence.Embedded;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ClienteDto {

    private Long id;

    @Embedded
    private String CPF;

    private String nome;
    private LocalDate dataNasc;
}
