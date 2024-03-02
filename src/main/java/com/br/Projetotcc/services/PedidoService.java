package com.br.Projetotcc.services;


import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.entities.enums.Categorias;
import com.br.Projetotcc.entities.enums.Estado;
import com.br.Projetotcc.exceptions.*;
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


    public List<Pedido> list(){
        return pedidoRepository.findAll();
    }

    public PedidoDTO addAoCardapio(Pedido pedido) throws ItIsNotPossibleToAddAProductToTheMenuWithTheSameId {
        Long pedidoId = pedido.getId();
        Optional<Pedido> pedidos = pedidoRepository.findById(pedidoId);
        if(pedidos.isPresent()){
            throw new ItIsNotPossibleToAddAProductToTheMenuWithTheSameId(pedido.getId());
        }
        pedido.setCategorias(pedido.getCategorias());
        pedido.setId(pedido.getId());
        pedido = pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);
    }
    public Pedido searchProduto(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new PedidoResourceNotFoundException(id));
    }
    public PedidoDTO addOrderInMesa(String mesa, Long id) {
        Mesas mesas = mesasRepository.findByMesas(mesa).orElseThrow(() -> new MesasResourceNotFoundException(mesa));
        Pedido pedido = searchProduto(id);
        mesas.addPedidos(pedido);
        mesas.setEstado(Estado.OCUPADO);
        pedido.setMesas(mesas);
        mesasRepository.save(mesas);
        pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);

    }

    public Pedido editarPedidoNoCardapio(Long id, Pedido pedido) throws UnableToEditAnOrderFromATable {
        Pedido pedidos = searchProduto(id) ;
        if(pedidos.getMesas() != null){
            throw new UnableToEditAnOrderFromATable(id);
        }
        pedido.setCategorias(pedido.getCategorias());
        pedido.setId(pedido.getId());
        pedido.setNome(pedido.getNome());
        pedido.setPreco(pedido.getPreco());
        pedidoRepository.save(pedido);
        return pedido;
    }

    public Pedido delete(Long id) throws UnableToDeleteAnOrderFromATable {
        Pedido pedido = searchProduto(id);
        if(pedido.getMesas() != null){
            throw new UnableToDeleteAnOrderFromATable(id);
        }
        pedidoRepository.delete(pedido);
        return pedido;
    }



}
