package br.com.zupacademy.marciosouza.transacao.config.exception;

public class TransacationNotFoundException extends RuntimeException {

    private String message;

    public TransacationNotFoundException(String message) {
        super(message);
    }
}
