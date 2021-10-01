package br.com.estudo.api.cinema.estudo.entity;

import br.com.estudo.api.cinema.estudo.model.Cliente;
import br.com.estudo.api.cinema.estudo.model.Sessao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    ClienteEntity cliente;

    @OneToOne
    SessaoEntity sessao;

    @ManyToOne
    SalaEntity sala;

}
