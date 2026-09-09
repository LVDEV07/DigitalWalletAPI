package com.DigitalWallet.exception;

import java.math.BigDecimal;

public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException(BigDecimal valor) {
        super("O valor: " + valor + "é inválido, informe um valor maior que zero");
    }
}
