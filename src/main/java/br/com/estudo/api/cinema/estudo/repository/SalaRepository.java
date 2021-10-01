package br.com.estudo.api.cinema.estudo.repository;

import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<SalaEntity, Long> {
}
