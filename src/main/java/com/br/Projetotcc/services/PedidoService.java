package com.br.Projetotcc.services;


import com.br.Projetotcc.dtos.MesasDTO;
import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.exceptions.ResourceNotFoundException;
import com.br.Projetotcc.repository.MesasRepository;
import com.br.Projetotcc.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MesasRepository mesasRepository;


    public List<Pedido> list(){
        return pedidoRepository.findAll();
    }

    public PedidoDTO addAoCardapio(Pedido pedido){
        pedido.setId(pedido.getId());
        pedido = pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);
    }
    public Pedido searchProduto(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public PedidoDTO addOrderInMesa(Long mesa, Long id) {
        Mesas mesas = mesasRepository.findById(mesa).orElseThrow(() -> new ResourceNotFoundException(mesa));
        Pedido pedido = searchProduto(id);
        mesas.addPedidos(pedido);
        mesasRepository.save(mesas);
        pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);

    }

    public Pedido editarPedidoNoCardapio(Long id, PedidoDTO pedido){
        Long novoId = pedido.getId();
        String novoNome = pedido.getNome();
        double novoPreco = pedido.getPreco();
        Pedido pedidos = searchProduto(id);
        pedidos.setId(novoId);
        pedidos.setNome(novoNome);
        pedidos.setPreco(novoPreco);
        pedidoRepository.save(pedidos);
        return pedidos;
    }

    public Pedido delete(Long id){
        Pedido pedido = searchProduto(id);
        if(pedido != null){
            pedidoRepository.delete(pedido);
        }
        return pedido;
    }


}
