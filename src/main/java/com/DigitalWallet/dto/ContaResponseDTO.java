package com.DigitalWallet.dto;

import com.DigitalWallet.model.Transacao;

import java.math.BigDecimal;
import java.util.List;

public record ContaResponseDTO (
        String nome,
        String cpf,
        BigDecimal saldo,
        List<Transacao> transacoes
) {
}
