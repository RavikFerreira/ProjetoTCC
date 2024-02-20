package com.br.Projetotcc.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mesas implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Long mesa;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    private double conta = 0.0;

    public Mesas(Long mesa, List<Pedido> pedidos, double conta) {
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.conta = conta;
    }
    public Mesas(){}
    public Long getMesa() {
        return mesa;
    }
    public void setMesa(Long mesa) {
        this.mesa = mesa;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void addPedidos(Pedido addPedidos){
        pedidos.add(addPedidos);
    }
    public double getConta() {
        return conta;
    }
    public void setConta(double conta) {
        this.conta = conta;
    }
}
