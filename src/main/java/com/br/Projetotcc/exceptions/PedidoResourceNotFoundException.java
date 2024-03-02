package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class PedidoResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public PedidoResourceNotFoundException(Object id) {
        super("Não existe pedido com esse id: " + id);
    }
}
