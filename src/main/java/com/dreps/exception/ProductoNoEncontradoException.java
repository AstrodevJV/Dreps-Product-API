package com.dreps.exception;

import java.beans.XMLEncoder;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}
