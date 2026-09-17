package com.DigitalWallet.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidacao(MethodArgumentNotValidException ex) {
        List<Map<String, String>> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(erro -> Map.of("campo", erro.getField(), "mensagem", erro.getDefaultMessage()))
                .toList();

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 400);
        body.put("erros", erros);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> contaNaoEncontrada (ContaNaoEncontradaException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 404);
        body.put("erros", List.of(Map.of(

                "mensagem", "Conta não encontrada"
        )));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ValorInvalidoException.class)
    public ResponseEntity<Map<String, Object>> valorInvalido (ValorInvalidoException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 400);
        body.put("erros", List.of(Map.of(
                "mensagem", "Valor informado é inválido"
        )));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(CpfJaCadastrado.class)
    public ResponseEntity<Map<String, Object>> cpfJaCadastrado (CpfJaCadastrado ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 409);
        body.put("erros", List.of(Map.of(
                "mensagem", "Conta já cadastrada"
        )));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

}
