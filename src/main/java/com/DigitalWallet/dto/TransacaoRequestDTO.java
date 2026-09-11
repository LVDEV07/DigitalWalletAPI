package com.DigitalWallet.dto;

import com.DigitalWallet.model.Conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoRequestDTO (
    BigDecimal valor,
    LocalDateTime data

)
{

}
