package com.br.Projetotcc.services;

import com.br.Projetotcc.dtos.MesasDTO;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.exceptions.ResourceNotFoundException;
import com.br.Projetotcc.repository.MesasRepository;
import com.br.Projetotcc.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MesaService {

    private final PedidoRepository pedidoRepository;

    private final MesasRepository mesasRepository;

    public List<Mesas> list(){
        return mesasRepository.findAll();
    }

    public MesasDTO addOrder(Mesas mesas){
        mesas.setPedidos(mesas.getPedidos());
        mesasRepository.save(mesas);
        return new MesasDTO(mesas);
    }

    public Mesas search(Long id){
        Mesas mesa = mesasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        List<Pedido> pedidos = new ArrayList<>();
        double total = 0.0;
        for(Pedido pedido : pedidos){
            total += pedido.getPreco();
            mesa.setConta(total);
        }
        return mesa;
    }

//    public double calcularTotalDaConta(Mesas mesa) {
//        List<Pedido> pedidos = pedidoRepository.findByMesas(mesa);
//
//        return pedidos;
//    }

}
