package br.com.estudo.api.cinema.estudo.repository;

import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

//    int countBySessaoId();
}
