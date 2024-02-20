package com.br.Projetotcc.dtos;

import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class MesasDTO {
    private Long mesa;
    private List<Pedido> pedidos;
    private double conta;

    public MesasDTO(Mesas mesasDto) {
        mesa = mesasDto.getMesa();
        pedidos =  mesasDto.getPedidos();
        conta = mesasDto.getConta();
    }

}
