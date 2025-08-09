package com.igor_nascimento.sistema_produtos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    // Busca usuário por email
    Optional<Usuarios> findByEmail(String email);
    // Busca usuário por senha
    Optional<Usuarios> findBySenha(String senha);
}
