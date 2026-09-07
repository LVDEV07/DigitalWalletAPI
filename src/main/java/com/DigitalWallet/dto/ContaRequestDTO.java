package com.DigitalWallet.dto;

import com.DigitalWallet.model.Extrato;

import java.math.BigDecimal;
import java.util.List;

public record ContaRequestDTO(
        String nome,
        String cpf,
        BigDecimal saldo
) {
}
