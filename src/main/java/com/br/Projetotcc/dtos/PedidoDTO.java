package com.br.Projetotcc.dtos;

import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PedidoDTO {
    private Long id;
    private String nome;
    private Double preco;


    public PedidoDTO(Pedido pedidos) {
        id = pedidos.getId();
        nome = pedidos.getNome();
        preco = pedidos.getPreco();
    }
}
