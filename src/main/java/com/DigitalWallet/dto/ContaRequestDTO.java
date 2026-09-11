package com.DigitalWallet.dto;

import java.math.BigDecimal;

public record ContaRequestDTO(
        String nome,
        String cpf,
        BigDecimal saldo

) {
}
