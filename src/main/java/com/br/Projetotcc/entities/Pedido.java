package com.br.Projetotcc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String nome;
    private Double preco;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mesas_id")
    @JsonIgnore
    private Mesas mesas ;

    public Pedido(Long id, String nome, Double preco, Mesas mesas) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.mesas = mesas;

    }
    public Pedido() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Mesas getMesas() {
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }


}
