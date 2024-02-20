package com.br.Projetotcc.controllers;

import com.br.Projetotcc.dtos.MesasDTO;
import com.br.Projetotcc.dtos.PedidoDTO;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.exceptions.ResourceNotFoundException;
import com.br.Projetotcc.services.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("list")
    @ResponseBody
    public ResponseEntity<List<Mesas>> listPedidos(){
        return ResponseEntity.ok(mesaService.list());
    }
//    @PostMapping("create")
//    public ResponseEntity<MesasDTO> create(@RequestBody Mesas mesas){
//        return ResponseEntity.ok(mesaService.create(mesas));
//    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<MesasDTO> addOrderInMesa( @RequestBody Mesas mesas) throws ResourceNotFoundException {
        MesasDTO addMesas = mesaService.addOrder(mesas);
        return new ResponseEntity<>(addMesas, HttpStatus.CREATED);
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Mesas> search(@PathVariable Long id){
        Mesas mesas = mesaService.search(id);
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

//    @GetMapping("/{id}/conta")
//    public ResponseEntity<Double> calcularConta(@PathVariable Long id) {
//        Mesas mesas = new Mesas();
//        mesas.setMesa(id);
//        double total = mesaService.calcularTotalDaConta(mesas);
//        return ResponseEntity.ok(total);
//    }
}
