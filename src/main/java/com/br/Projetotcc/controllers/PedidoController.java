package com.br.Projetotcc.controllers;

import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.exceptions.*;
import com.br.Projetotcc.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("pedido/")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("list")
    @ResponseBody
    public ResponseEntity<List<Pedido>> listPedidos(){
        return ResponseEntity.ok(pedidoService.list());
    }


    @PostMapping("addOrder/{id}/InMesa/{mesa}")
    public ResponseEntity<Pedido> addOrderInMesa(@PathVariable String mesa, @PathVariable Long id) throws PedidoResourceNotFoundException {
        Pedido pedidoDto = pedidoService.addOrderInMesa(mesa, id);
         return new ResponseEntity<>(pedidoDto, HttpStatus.CREATED);
    }
}
