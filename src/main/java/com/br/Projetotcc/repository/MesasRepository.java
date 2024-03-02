package com.br.Projetotcc.repository;

import com.br.Projetotcc.entities.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Long> {
    @Query("SELECT m " +
            "FROM Mesas m " +
            "WHERE " +
            "m.mesa = :mesa")
    Optional<Mesas> findByMesas(String mesa);
}
