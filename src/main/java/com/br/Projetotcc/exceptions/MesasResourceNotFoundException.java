package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class MesasResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public MesasResourceNotFoundException(Object id) {
        super("Não existe mesa com esse id: " + id);
    }
}
