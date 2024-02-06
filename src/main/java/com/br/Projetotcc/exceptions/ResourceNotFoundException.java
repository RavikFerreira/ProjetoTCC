package com.br.Projetotcc.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(Object id) {
        super("Resources not found. Id " + id);
    }
}
