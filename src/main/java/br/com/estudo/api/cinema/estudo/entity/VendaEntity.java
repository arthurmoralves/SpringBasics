package br.com.estudo.api.cinema.estudo.entity;

import br.com.estudo.api.cinema.estudo.model.Cliente;
import br.com.estudo.api.cinema.estudo.model.Sessao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ClienteEntity cliente;

    @OneToOne
    private SessaoEntity sessao;

    @ManyToOne
    private SalaEntity sala;

    public VendaEntity(ClienteEntity cliente, SessaoEntity sessao, SalaEntity sala) {
        this.cliente = cliente;
        this.sessao = sessao;
        this.sala = sala;
    }
}
