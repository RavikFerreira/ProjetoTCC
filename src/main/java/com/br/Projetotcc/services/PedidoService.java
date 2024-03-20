package com.br.Projetotcc.services;


import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Cardapio;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.entities.enums.Categorias;
import com.br.Projetotcc.entities.enums.Estado;
import com.br.Projetotcc.exceptions.*;
import com.br.Projetotcc.repository.CardapioRepository;
import com.br.Projetotcc.repository.MesasRepository;
import com.br.Projetotcc.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MesasRepository mesasRepository;
    private final CardapioRepository cardapioRepository;


    public List<Pedido> list(){
        return pedidoRepository.findAll();
    }

    public Pedido addOrderInMesa(String mesa, Long id) {
        Mesas mesas = mesasRepository.findByMesas(mesa).orElseThrow(() -> new MesasResourceNotFoundException(mesa));
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new PedidoResourceNotFoundException(id));
        List<Pedido> pedidos = mesas.getPedidos();
        mesas.setEstado(Estado.OCUPADO);
        mesas.addPedidos(pedido);
        pedido.setMesas(mesas);
        mesasRepository.save(mesas);
        pedidoRepository.save(pedido);
        return pedido;

    }
}
