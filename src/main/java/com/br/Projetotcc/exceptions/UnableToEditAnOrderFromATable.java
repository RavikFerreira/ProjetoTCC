package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class UnableToEditAnOrderFromATable extends Throwable {
    @Serial
    private static final long serialVersionUID = 1L;
    public UnableToEditAnOrderFromATable(Long id) {
        super("Não é possível editar um pedido de uma mesa! Id: "+id);
    }
}
