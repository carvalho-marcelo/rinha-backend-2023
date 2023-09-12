package br.com.duck.exception;

public class UnprocessableException extends RuntimeException {
    public UnprocessableException(Throwable cause) {
        super(cause);
    }
}
