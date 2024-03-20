package com.br.Projetotcc.repository;

import com.br.Projetotcc.entities.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
