package com.br.Projetotcc.services;

import com.br.Projetotcc.dtos.MesasDTO;
import com.br.Projetotcc.entities.Cardapio;
import com.br.Projetotcc.entities.Mesas;
import com.br.Projetotcc.entities.Pedido;
import com.br.Projetotcc.entities.enums.Estado;
import com.br.Projetotcc.exceptions.CannotCreateATableWithTheSameId;
import com.br.Projetotcc.exceptions.CannotDeleteABusyTable;
import com.br.Projetotcc.exceptions.MesasResourceNotFoundException;
import com.br.Projetotcc.repository.MesasRepository;
import com.br.Projetotcc.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class MesaService {

    private final PedidoRepository pedidoRepository;

    private final MesasRepository mesasRepository;

    public List<Mesas> list(){
        List<Mesas> mesas = mesasRepository.findAll();
        for(Mesas mesa: mesas){
            List<Pedido> pedidos = mesa.getPedidos();
            double total = 0.0;
//            for(Pedido pedido: pedidos){
//                total += pedido.getTotal();
//            }
            mesa.setConta(total);
        }
        return mesas;
    }

    public MesasDTO addMesas(Mesas mesas) throws CannotCreateATableWithTheSameId {
        String mesa = mesas.getMesa();
        Optional<Mesas> mesaExiste = mesasRepository.findByMesas(mesa);
        if(mesaExiste.isPresent()){
            throw new CannotCreateATableWithTheSameId(mesas.getMesa());
        }
        mesas.setPedidos(mesas.getPedidos());
        mesas.setEstado(Estado.LIVRE);
        mesasRepository.save(mesas);
        return new MesasDTO(mesas);

    }

    public Mesas search(String mesa){
        Mesas mesas = mesasRepository.findByMesas(mesa).orElseThrow(() -> new MesasResourceNotFoundException(mesa));
        List<Pedido> pedidos = mesas.getPedidos();
        double total = 0.0;
        for(Pedido pedido : pedidos){
            List<Cardapio> cardapios = pedido.getCardapio();
            for(Cardapio cardapio : cardapios){
                total += cardapio.getPreco();
            }
        }
        mesas.setConta(total);

        return mesas;
    }

    public Mesas delete(String mesa) throws CannotDeleteABusyTable {
        Mesas mesas = search(mesa);
        if(mesas.getEstado() == Estado.OCUPADO){
          throw new CannotDeleteABusyTable(mesa);
        } if(mesas != null){
            mesasRepository.delete(mesas);
        }
        return mesas;
    }

}
