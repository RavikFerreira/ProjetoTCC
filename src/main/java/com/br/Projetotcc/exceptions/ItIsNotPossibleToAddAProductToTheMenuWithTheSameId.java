package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class ItIsNotPossibleToAddAProductToTheMenuWithTheSameId extends Throwable {

    @Serial
    private static final long serialVersionUID = 1L;
    public ItIsNotPossibleToAddAProductToTheMenuWithTheSameId(Long id) {
        super("Não é possível adicionar ao menu um produto com o mesmo identificador! " +id);
    }
}
