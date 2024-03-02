package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class CannotDeleteABusyTable extends Throwable {

    @Serial
    private static final long serialVersionUID = 1L;
    public CannotDeleteABusyTable(String mesa) {
        super("Não é possível deletar uma mesa ocupada! Id: "+mesa);
    }
}

