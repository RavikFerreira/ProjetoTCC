package com.br.Projetotcc.services;

import com.br.Projetotcc.dtos.CardapioDTO;
import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Cardapio;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.entities.enums.Estado;
import com.br.Projetotcc.exceptions.ItIsNotPossibleToAddAProductToTheMenuWithTheSameId;
import com.br.Projetotcc.exceptions.MesasResourceNotFoundException;
import com.br.Projetotcc.exceptions.PedidoResourceNotFoundException;
import com.br.Projetotcc.exceptions.UnableToDeleteAnOrderFromATable;
import com.br.Projetotcc.exceptions.UnableToEditAnOrderFromATable;
import com.br.Projetotcc.repository.CardapioRepository;
import com.br.Projetotcc.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardapioService {

    private final CardapioRepository cardapioRepository;
    private final PedidoRepository pedidoRepository;

    public List<Cardapio> cardapioList(){
        return cardapioRepository.findAll();
    }

    public Cardapio addAoCardapio(Cardapio cardapio) throws ItIsNotPossibleToAddAProductToTheMenuWithTheSameId {
        Long pedidoId = cardapio.getId();
        Optional<Cardapio> pedidos = cardapioRepository.findById(pedidoId);
        if(pedidos.isPresent()){
            throw new ItIsNotPossibleToAddAProductToTheMenuWithTheSameId(cardapio.getId());
        }
        cardapio.setCategorias(cardapio.getCategorias());
        cardapio.setId(cardapio.getId());
        cardapio = cardapioRepository.save(cardapio);
        return cardapio;
    }
    public Cardapio searchProduto(Long id){
        return cardapioRepository.findById(id).orElseThrow(() -> new PedidoResourceNotFoundException(id));
    }
    public Cardapio addCardapioInPedido(Long idCardapio) {
        Pedido pedido = new Pedido();
        Long idPedidos =  pedido.getId();
        Cardapio cardapio = cardapioRepository.findById(idCardapio).orElseThrow(() -> new PedidoResourceNotFoundException(idCardapio));
        pedido.addCardapioAoPedido(cardapio);
        cardapioRepository.save(cardapio);
        pedidoRepository.save(pedido);
        return cardapio;

    }

    public Cardapio editarPedidoNoCardapio(Long id, Cardapio cardapio) {
        Cardapio produto = searchProduto(id);
        cardapio.setCategorias(cardapio.getCategorias());
        cardapio.setId(cardapio.getId());
        cardapio.setNome(cardapio.getNome());
        cardapio.setPreco(cardapio.getPreco());
        cardapioRepository.save(cardapio);
        return cardapio;
    }

    public Cardapio delete(Long id) {
        Cardapio cardapio = searchProduto(id);
        cardapioRepository.delete(cardapio);
        return cardapio;
    }
}
