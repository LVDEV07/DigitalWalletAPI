package com.DigitalWallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoRequestDTO (
    BigDecimal valor,
    LocalDateTime data
)
{

}
