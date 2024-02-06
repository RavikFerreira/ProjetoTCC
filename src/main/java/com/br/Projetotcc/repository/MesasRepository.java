package com.br.Projetotcc.repository;

import com.br.Projetotcc.entities.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Long> {
}
