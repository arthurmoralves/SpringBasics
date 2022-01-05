package br.com.estudo.api.cinema.estudo.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class SessaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sessao_id")
    private Long id;

    private BigDecimal valor;
    private String titulo;

    @ManyToOne
    SalaEntity sala;

}
