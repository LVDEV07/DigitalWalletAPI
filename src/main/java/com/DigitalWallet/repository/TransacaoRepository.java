package com.DigitalWallet.repository;

import com.DigitalWallet.model.Conta;
import com.DigitalWallet.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
