package br.com.estudo.api.cinema.estudo.repository;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoEntity, Long> {
    Sessao findByTitulo(String titulo);
}
