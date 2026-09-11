package com.DigitalWallet.service;

import com.DigitalWallet.dto.ContaRequestDTO;
import com.DigitalWallet.dto.ContaResponseDTO;
import com.DigitalWallet.dto.TransacaoRequestDTO;
import com.DigitalWallet.dto.TransacaoResponseDTO;
import com.DigitalWallet.exception.ContaNaoEncontradaException;
import com.DigitalWallet.exception.ValorInvalidoException;
import com.DigitalWallet.mapper.ContaMapper;
import com.DigitalWallet.mapper.TransacaoMapper;
import com.DigitalWallet.model.Conta;
import com.DigitalWallet.model.Transacao;
import com.DigitalWallet.repository.ContaRepository;
import com.DigitalWallet.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContaService {
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public ContaService(ContaRepository contaRepository, TransacaoRepository transacaoRepository) {
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
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

    public TransacaoResponseDTO deposito (Long id, TransacaoRequestDTO transacao){
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException(HttpStatus.NOT_FOUND,id));

        if (transacao.valor().compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorInvalidoException(transacao.valor());
        }

        Transacao deposito = TransacaoMapper.toRequestDTO(transacao);
        Transacao deposito1 = transacaoRepository.save(deposito);

        conta.setSaldo(conta.getSaldo().add(deposito1.getValor()));
        List<Transacao> transacoes = conta.getTransacoes();

        transacoes.add(deposito1);

        conta.setTransacoes(transacoes);
        contaRepository.save(conta);

        return TransacaoMapper.toResponseDTO(deposito1);
    }
}
