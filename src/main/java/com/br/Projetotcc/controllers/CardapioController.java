package com.br.Projetotcc.controllers;

import com.br.Projetotcc.dtos.CardapioDTO;
import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Cardapio;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.exceptions.*;
import com.br.Projetotcc.services.CardapioService;
import com.br.Projetotcc.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("cardapio/")
public class CardapioController {

    private final CardapioService cardapioService;

    @GetMapping("cardapio")
    @ResponseBody
    public ResponseEntity<List<Cardapio>> listPedidos(){
        return ResponseEntity.ok(cardapioService.cardapioList());
    }

    @PostMapping("addCardapio")
    @ResponseBody
    public ResponseEntity<Cardapio> addAoCardapio(@RequestBody Cardapio cardapio) throws ItIsNotPossibleToAddAProductToTheMenuWithTheSameId {
        Cardapio cardapioDto = cardapioService.addAoCardapio(cardapio);
        return new ResponseEntity<>(cardapioDto, HttpStatus.CREATED);
    }
    @GetMapping("searchProduto/{id}")
    public ResponseEntity<Cardapio> search(@PathVariable Long id){
        Cardapio produto = cardapioService.searchProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    @PostMapping("addCardapioAoPedido/{idCardapio}")
    public ResponseEntity<Cardapio> addOrderInMesa(@PathVariable Long idCardapio) throws PedidoResourceNotFoundException {
        Cardapio cardapio = cardapioService.addCardapioInPedido(idCardapio);
        return new ResponseEntity<>(cardapio, HttpStatus.CREATED);
    }
    @PatchMapping("editarPedidoCardapio/{id}")
    public ResponseEntity<Cardapio> editarPedidoNoCardapio(@PathVariable Long id, @RequestBody Cardapio cardapio) throws UnableToEditAnOrderFromATable {
        Cardapio produtos = cardapioService.editarPedidoNoCardapio(id, cardapio);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Cardapio> delete(@PathVariable Long id){
        cardapioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
