package br.com.estudo.api.cinema.estudo.entity;

import br.com.estudo.api.cinema.estudo.model.Sessao;
import br.com.estudo.api.cinema.estudo.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SalaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacidade;
}
