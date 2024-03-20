package com.br.Projetotcc.entities;

import com.br.Projetotcc.entities.enums.Categorias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cardapio")
public class Cardapio implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String nome;
    private Double preco = 0.0;
    private Categorias categorias;
    @ManyToOne
    @JsonIgnore
    private Pedido pedidos;

    public Cardapio(Long id, String nome, Double preco, Categorias categorias, Pedido pedidos) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categorias = categorias;
        this.pedidos = pedidos;
    }
    public Cardapio() {}

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

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }
}
