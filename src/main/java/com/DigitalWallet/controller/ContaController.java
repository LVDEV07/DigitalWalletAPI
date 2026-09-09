package com.DigitalWallet.controller;

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
import com.DigitalWallet.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ContaResponseDTO criar (@RequestBody ContaRequestDTO contaRequestDTO){
        return contaService.criar(contaRequestDTO);
    }

    @GetMapping("{id}")
    public ContaResponseDTO buscarPorId (@PathVariable Long id){
       return contaService.buscarPorId(id);

    }

    @PostMapping("{id}/deposit")
    public TransacaoResponseDTO deposito (@PathVariable Long id, @RequestBody TransacaoRequestDTO transacao){
       return contaService.deposito(id, transacao);
    }

}
