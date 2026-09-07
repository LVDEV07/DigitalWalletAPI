package com.DigitalWallet.service;

import com.DigitalWallet.dto.ContaRequestDTO;
import com.DigitalWallet.dto.ContaResponseDTO;
import com.DigitalWallet.exception.ContaNaoEncontradaException;
import com.DigitalWallet.mapper.ContaMapper;
import com.DigitalWallet.model.Conta;
import com.DigitalWallet.repository.ContaRepository;
import org.springframework.http.HttpStatus;

public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public ContaResponseDTO criar (ContaRequestDTO conta){
        Conta newUser = ContaMapper.toRequestDTO(conta);
        Conta conta1 = contaRepository.save(newUser);

        return ContaMapper.toResponseDTO(conta1);
    }

    public ContaResponseDTO buscarPorId (Long id){
        Conta conta =
                contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException(HttpStatus.NOT_FOUND,id));
        return ContaMapper.toResponseDTO(conta);
    }
}
