package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class CannotCreateATableWithTheSameId extends Throwable {
    @Serial
    private static final long serialVersionUID = 1L;
    public CannotCreateATableWithTheSameId(Long id) {
        super("Não é possível criar uma mesa com o mesmo id: " + id);
    }
}
