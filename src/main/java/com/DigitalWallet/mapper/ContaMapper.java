package com.DigitalWallet.mapper;

import com.DigitalWallet.dto.ContaRequestDTO;
import com.DigitalWallet.dto.ContaResponseDTO;
import com.DigitalWallet.model.Conta;


public class ContaMapper {
    public static ContaResponseDTO toResponseDTO(Conta conta){
        return new ContaResponseDTO(conta.getNome(), conta.getCpf(), conta.getSaldo());
    }

    public static Conta toRequestDTO(ContaRequestDTO conta){
        Conta newConta = new Conta();

        newConta.setCpf(conta.cpf());
        newConta.setNome(conta.nome());
        newConta.setSaldo(conta.saldo());

        return newConta;
    }
}
