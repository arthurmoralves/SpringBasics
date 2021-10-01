package br.com.estudo.api.cinema.estudo.repository;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
