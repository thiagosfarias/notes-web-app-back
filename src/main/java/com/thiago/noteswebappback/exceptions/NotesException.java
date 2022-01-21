package com.thiago.noteswebappback.exceptions;

public class NotesException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotesException(String mensagem) {
        super(mensagem);
    }

    public NotesException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
