package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class UnableToDeleteAnOrderFromATable extends Throwable {

    @Serial
    private static final long serialVersionUID = 1L;
    public UnableToDeleteAnOrderFromATable(Long id) {
        super("Não é possível excluir um pedido de uma mesa! Id: "+id);
    }
}

