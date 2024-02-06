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

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MesaService mesaService;
    private final MesasRepository mesasRepository;
    private final PedidoService pedidoService;

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
    public PedidoDTO addOrderInMesa(Long id, Pedido pedido) {
    Mesas mesas = mesaService.search(id);
//    if(mesas.getMesa() == id){
//        Pedido produto = pedidoService.searchProduto(pedido.getId());
//        if(pedidoService.searchProduto(pedido.getId())){
//
//        }
        mesas.addPedidos(pedido);
        mesasRepository.save(mesas);
        pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);
    }
//    return new PedidoDTO(pedido);
    

}
