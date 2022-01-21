package com.thiago.noteswebappback.exceptions;

public class UserException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserException(String mensagem) {
        super(mensagem);
    }
}
