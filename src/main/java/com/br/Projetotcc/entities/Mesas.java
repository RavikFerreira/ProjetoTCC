package com.br.Projetotcc.entities;

import com.br.Projetotcc.entities.enums.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_mesas")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mesas implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn(referencedColumnName = "mesa_id")
    @JsonIgnore
    private Long id;
    private String mesa;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    private double conta = 0.0;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Mesas(Long id,String mesa, List<Pedido> pedidos, double conta, Estado estado) {
        this.id = id;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.conta = conta;
        this.estado = estado;
    }
    public Mesas(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMesa() {
        return mesa;
    }
    public void setMesa(String mesa) {
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
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
