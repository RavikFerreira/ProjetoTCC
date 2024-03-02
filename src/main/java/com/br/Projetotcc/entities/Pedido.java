package com.br.Projetotcc.entities;

import com.br.Projetotcc.entities.enums.Categorias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String nome;
    private Double preco = 0.0;
    @Enumerated(EnumType.STRING)
    private Categorias categorias;
    @ManyToOne()
    @JoinColumn(name = "mesa_id")
    @JsonIgnore
    private Mesas mesas;


    public Pedido(Long id, String nome, Double preco, Mesas mesas, Categorias categorias) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.mesas = mesas;
        this.categorias = categorias;
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

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Mesas getMesas() {
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }


}
