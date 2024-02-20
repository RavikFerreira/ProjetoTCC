package com.br.Projetotcc.repository;

import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p " +
            "FROM Pedido p " +
            "WHERE " +
            "p.mesas = :id")
    List<Pedido> findByMesas(Mesas id);
}
