package br.com.estudo.api.cinema.estudo.repository;

import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

    @Query(value = "SELECT COUNT(SESSAO.SESSAO_ID) " +
            "FROM VENDA_ENTITY VENDA INNER JOIN VENDA_SESSAO SESSAO ON VENDA.ID = SESSAO.VENDA_ID" +
            " WHERE SESSAO_ID = id", nativeQuery = true)
    Integer countBySessaoId(Long id);
}
