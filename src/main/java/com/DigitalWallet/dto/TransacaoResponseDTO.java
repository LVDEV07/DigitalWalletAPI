package com.DigitalWallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoResponseDTO(
        Long id,
        BigDecimal valor,
        LocalDateTime data
) {
}
