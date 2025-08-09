package com.igor_nascimento.sistema_produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.exceptions.CredenciaisInvalidasException;
import com.igor_nascimento.sistema_produtos.models.Usuarios;
import com.igor_nascimento.sistema_produtos.repository.UsuarioRepository;

@Service
public class AuthService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios registrar(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }

    public Usuarios login(String email, String senha) {
        return usuarioRepository.findByEmail(email)
            .filter(usuario -> usuario.getSenha().equals(senha))
            .orElseThrow(() -> new CredenciaisInvalidasException("E-mail ou senha inválidos!"));
    }

    public Usuarios getAuthenticadorUsuario(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
