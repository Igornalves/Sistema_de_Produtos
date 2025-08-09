package com.igor_nascimento.sistema_produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.exceptions.CredenciaisInvalidasException;
import com.igor_nascimento.sistema_produtos.models.Usuarios;
import com.igor_nascimento.sistema_produtos.repository.UsuarioRepository;

@Service
public class AuthService {

    // Injeta o repositório de usuários para acesso ao banco de dados
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registra um novo usuário
    public Usuarios registrar(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }

    // Login do usuário
    public Usuarios login(String email, String senha) {
        return usuarioRepository.findByEmail(email)
            .filter(usuario -> usuario.getSenha().equals(senha))
            .orElseThrow(() -> new CredenciaisInvalidasException("E-mail ou senha inválidos!"));
    }

    // Busca usuário pelo ID
    public Usuarios getAuthenticadorUsuario(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
