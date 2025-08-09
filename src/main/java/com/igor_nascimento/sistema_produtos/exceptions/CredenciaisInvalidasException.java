package com.igor_nascimento.sistema_produtos.exceptions;

// Exceção para login inválido
public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException(String message) {
        super(message); // Mostra mensagem de erro de login
    }
}
