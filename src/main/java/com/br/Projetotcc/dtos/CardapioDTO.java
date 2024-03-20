package com.br.Projetotcc.dtos;

import com.br.Projetotcc.entities.Cardapio;
import com.br.Projetotcc.entities.enums.Categorias;
import lombok.Data;

@Data
public class CardapioDTO {

    private Long id;
    private String nome;
    private Double preco;
    private Categorias categorias;

    public CardapioDTO(Cardapio cardapio){
        id = cardapio.getId();
        nome = cardapio.getNome();
        preco = cardapio.getPreco();
        categorias = cardapio.getCategorias();
    }
}
