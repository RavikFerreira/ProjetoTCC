package com.br.Projetotcc.entities;

import com.br.Projetotcc.entities.enums.Categorias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "mesa_id")
    @JsonIgnore
    private Mesas mesas;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Cardapio> cardapio = new ArrayList<>();

    public Pedido(Long id,  Mesas mesas,  List<Cardapio> cardapio) {
        this.id = id;
        this.mesas = mesas;
        this.cardapio = cardapio;
    }
    public Pedido() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesas getMesas() {
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }

    public  List<Cardapio> getCardapio() {
        return cardapio;
    }

    public void setCardapio( List<Cardapio> cardapio) {
        this.cardapio = cardapio;
    }

    public void addCardapioAoPedido(Cardapio addPedidos){
        cardapio.add(addPedidos);
    }
}
