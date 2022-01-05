package br.com.estudo.api.cinema.estudo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "VENDA_SESSAO",
            joinColumns = { @JoinColumn(name = "venda_id") },
            inverseJoinColumns = { @JoinColumn(name = "sessao_id") }
    )
    private List<SessaoEntity> sessoes;

    public VendaEntity(ClienteEntity cliente, List<SessaoEntity> sessao) {
        this.cliente = cliente;
        this.sessoes = sessao;
    }
}
