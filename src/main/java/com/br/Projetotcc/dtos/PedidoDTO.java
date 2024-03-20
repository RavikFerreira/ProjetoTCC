package com.br.Projetotcc.dtos;

import com.br.Projetotcc.entities.Cardapio;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PedidoDTO {
    private Long id;
    private Mesas mesas;
    private List<Cardapio> cardapio;


    public PedidoDTO(Pedido pedidos) {
        id = pedidos.getId();
        mesas = pedidos.getMesas();
        cardapio = pedidos.getCardapio();

    }
}
