package com.br.Projetotcc.controllers;

import com.br.Projetotcc.dtos.MesasDTO;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.exceptions.CannotCreateATableWithTheSameId;
import com.br.Projetotcc.exceptions.CannotDeleteABusyTable;
import com.br.Projetotcc.exceptions.MesasResourceNotFoundException;
import com.br.Projetotcc.services.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("mesas/")
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("list")
    @ResponseBody
    public ResponseEntity<List<Mesas>> listPedidos(){
        return ResponseEntity.ok(mesaService.list());
    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<MesasDTO> addOrder(@RequestBody Mesas mesas) throws MesasResourceNotFoundException, CannotCreateATableWithTheSameId {
        MesasDTO addMesas = mesaService.addMesas(mesas);
        return new ResponseEntity<>(addMesas, HttpStatus.CREATED);
    }

    @GetMapping("search/{mesa}")
    public ResponseEntity<Mesas> search(@PathVariable String mesa){
        Mesas mesas = mesaService.search(mesa);
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

    @DeleteMapping("delete/{mesa}")
    public ResponseEntity<Mesas> delete(@PathVariable String mesa) throws CannotDeleteABusyTable {
        mesaService.delete(mesa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
