package com.DigitalWallet.mapper;

import com.DigitalWallet.dto.TransacaoRequestDTO;
import com.DigitalWallet.dto.TransacaoResponseDTO;
import com.DigitalWallet.model.Transacao;

public class TransacaoMapper {
    public static TransacaoResponseDTO toResponseDTO (Transacao transacao){
        return new TransacaoResponseDTO(transacao.getId(),transacao.getValor(),transacao.getHoraTransacao());
    }

    public static Transacao toRequestDTO (TransacaoRequestDTO dto){
        Transacao transacao = new Transacao();

        transacao.setValor(dto.valor());
        transacao.setHoraTransacao(dto.data());

        return transacao;
    }
}
