package com.br.Projetotcc.controllers;

import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.exceptions.ResourceNotFoundException;
import com.br.Projetotcc.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("cardapio")
    @ResponseBody
    public ResponseEntity<List<Pedido>> listPedidos(){
        return ResponseEntity.ok(pedidoService.list());
    }

    @PostMapping("addCardapio")
    public ResponseEntity<PedidoDTO> addAoCardapio(@RequestBody Pedido pedido) {
        PedidoDTO pedidos = pedidoService.addAoCardapio(pedido);
        return new ResponseEntity<>(pedidos, HttpStatus.CREATED);
    }
    @PostMapping("addOrder/{id}/InMesa/{mesa}")
    public ResponseEntity<PedidoDTO> addOrderInMesa(@PathVariable Long mesa, @PathVariable Long id) throws ResourceNotFoundException {
        PedidoDTO pedidoDto = pedidoService.addOrderInMesa(mesa, id);
        return new ResponseEntity<>(pedidoDto, HttpStatus.CREATED);
    }
    @GetMapping("searchProduto/{id}")
    public ResponseEntity<Pedido> search(@PathVariable Long id){
        Pedido produto = pedidoService.searchProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PatchMapping("editarPedidoCardapio/{id}")
    public ResponseEntity<Pedido> editarPedidoNoCardapio(@PathVariable Long id, @RequestBody PedidoDTO pedido){
        Pedido pedidos = pedidoService.editarPedidoNoCardapio(id, pedido);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
}
