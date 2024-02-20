package com.br.Projetotcc.dtos;

import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;

import java.util.List;

public class ReturnValorContaDto {

    private Long mesa;
    private List<Pedido> pedidos;

    public ReturnValorContaDto(Mesas mesas){
        mesa = mesas.getMesa();
        pedidos = mesas.getPedidos();

    }

}
