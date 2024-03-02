package com.br.Projetotcc.dtos;

import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.entities.enums.Estado;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class MesasDTO {
    private Long id;
    private String mesa;
    private List<Pedido> pedidos;
    private double conta;
    private Estado estado;

    public MesasDTO(Mesas mesasDto) {
        id = mesasDto.getId();
        mesa = mesasDto.getMesa();
        pedidos =  mesasDto.getPedidos();
        conta = mesasDto.getConta();
        estado = mesasDto.getEstado();
    }

}
