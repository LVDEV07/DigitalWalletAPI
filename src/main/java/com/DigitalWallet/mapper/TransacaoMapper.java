package com.DigitalWallet.mapper;

import com.DigitalWallet.dto.TransacaoRequestDTO;
import com.DigitalWallet.dto.TransacaoResponseDTO;
import com.DigitalWallet.model.Transacao;

import java.time.LocalDateTime;

public class TransacaoMapper {
    public static TransacaoResponseDTO toResponseDTO (Transacao transacao){
        return new TransacaoResponseDTO(transacao.getId(),transacao.getValor(),transacao.getHoraTransacao());
    }

    public static Transacao toRequestDTO (TransacaoRequestDTO dto){
        Transacao transacao = new Transacao();

        transacao.setValor(dto.valor());
        transacao.setHoraTransacao(LocalDateTime.now());
        transacao.setId_destino(dto.id_destino());

        return transacao;
    }
}
