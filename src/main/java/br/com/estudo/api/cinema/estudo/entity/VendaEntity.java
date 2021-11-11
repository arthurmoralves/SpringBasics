package br.com.estudo.api.cinema.estudo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
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
