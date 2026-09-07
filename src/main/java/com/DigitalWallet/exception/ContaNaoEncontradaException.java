package com.DigitalWallet.exception;

import org.springframework.http.HttpStatus;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(HttpStatus status, Long id) {
        super("Conta não encontrada com o id: " + id);
    }
}
