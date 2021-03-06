package com.pokemon.pokemon.model.exception;
import org.springframework.core.NestedRuntimeException;

public class NotFoundException extends NestedRuntimeException {

    private String message;

    public NotFoundException(String msg) {
        super(msg);
    }
}
