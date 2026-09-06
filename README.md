# Desafio Técnico - API de Carteira Digital (Digital Wallet)

**Nível:** Júnior / Estágio avançado
**Stack:** Java + Spring Boot
**Formato:** Inspirado em desafios reais de backend usados por fintechs e big techs (estilo Nubank, Itaú, iFood)

---

## 1. Contexto

Você foi contratado(a) para desenvolver o backend de uma carteira digital simples. O sistema precisa permitir que usuários criem contas, façam depósitos, transfiram dinheiro entre contas e consultem seu extrato.

A empresa valoriza código limpo, bem testado e com regras de negócio bem isoladas — não apenas um CRUD genérico.

---

## 2. Objetivo

Construir uma API REST que gerencie contas e transações financeiras simples, aplicando boas práticas de arquitetura, validação e testes.

---

## 3. Requisitos Funcionais

Implemente os seguintes endpoints:

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/accounts` | Cria uma nova conta (nome do titular, CPF, saldo inicial opcional) |
| `GET` | `/accounts/{id}` | Retorna os dados e saldo atual da conta |
| `POST` | `/accounts/{id}/deposit` | Realiza um depósito na conta |
| `POST` | `/transfers` | Transfere valor entre duas contas (origem e destino) |
| `GET` | `/accounts/{id}/statement` | Retorna o extrato (histórico de transações) da conta, com paginação |

---

## 4. Regras de Negócio

1. Um CPF não pode ser cadastrado duas vezes.
2. Não é permitido depósito ou transferência com valor **zero ou negativo**.
3. Uma transferência só pode ocorrer se a conta de origem tiver **saldo suficiente**.
4. Não é permitido transferir para a **própria conta**.
5. Toda transação (depósito ou transferência) deve gerar um **registro no extrato**, com data/hora, tipo e valor.
6. Operações devem ser **atômicas**: se algo falhar no meio de uma transferência, nada deve ser persistido (nem debitado, nem creditado).
7. Valores monetários devem ser tratados com precisão adequada (evite `float`/`double` para dinheiro).

---

## 5. Requisitos Técnicos Obrigatórios

- Java 17+ e Spring Boot 3.x
- Spring Web, Spring Data JPA
- Banco de dados relacional (H2 em memória é suficiente para o teste; Postgres é um diferencial)
- Bean Validation (`jakarta.validation`) nos DTOs de entrada
- Tratamento de erros consistente (um `@ControllerAdvice` retornando um formato padronizado de erro, com status HTTP corretos: 400, 404, 409, 422 etc.)
- Testes automatizados:
    - Testes unitários da camada de regras de negócio (services)
    - Pelo menos alguns testes de integração dos endpoints principais (`@SpringBootTest` ou `MockMvc`)
- Separação clara de camadas (controller / service / repository / domínio)
- README com instruções claras de como rodar o projeto e os testes

---

## 6. Diferenciais (não obrigatórios, mas somam pontos)

- Docker e `docker-compose` para subir a aplicação + banco
- Documentação da API com Swagger/OpenAPI
- Uso de `BigDecimal` com escala e arredondamento bem definidos
- Padrão de projeto aplicado com justificativa (ex: Strategy para tipos de transação)
- Idempotência no endpoint de transferência (evitar transferência duplicada por retry)
- Migrations com Flyway ou Liquibase
- Paginação e ordenação no extrato usando `Pageable`
- Logs estruturados nas operações críticas

---

## 7. Requisitos Não Funcionais

- Código deve seguir convenções de nomenclatura e organização de pacotes do Java/Spring
- Commits organizados e com mensagens descritivas (evite um único commit "projeto final")
- Sem regras de negócio dentro do Controller
- Sem lógica de persistência dentro do Service (isso é responsabilidade do Repository)

---

## 8. Entregáveis

- Repositório público no GitHub (ou zip, se preferir)
- README contendo:
    - Como rodar a aplicação localmente
    - Como rodar os testes
    - Decisões de arquitetura relevantes (breve, não precisa ser um TCC)
    - O que você faria diferente com mais tempo

---

## 9. Critérios de Avaliação

| Critério | Peso |
|----------|------|
| Regras de negócio corretas e bem tratadas | Alto |
| Qualidade e cobertura dos testes | Alto |
| Organização e clareza do código | Alto |
| Tratamento de erros e casos de borda | Médio |
| Uso correto de Spring/JPA | Médio |
| Diferenciais implementados | Bônus |

---

## 10. Tempo Estimado

Entre **3 e 5 horas** de trabalho focado. Não é necessário implementar todos os diferenciais — prefira entregar menos com mais qualidade do que tudo pela metade.

---

## 11. Dica Final

Empresas como Nubank, Itaú e iFood costumam avaliar menos "quantos endpoints você fez" e mais **como você pensa sobre regras de negócio, edge cases e qualidade de código**. Um projeto pequeno e muito bem testado vale mais do que um grande e frágil.