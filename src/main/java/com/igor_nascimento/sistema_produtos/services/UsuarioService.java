package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Usuarios;
import com.igor_nascimento.sistema_produtos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    // Injeta o repositório de usuários para acesso ao banco de dados
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todos os usuários
    public List<Usuarios> listaTodos() {
        return usuarioRepository.findAll();
    }

    // Busca usuário por ID
    public Usuarios buscarPorId(long id){
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    // Cria um novo usuário
    public Usuarios criarUsuario(Usuarios usuarios){
        return usuarioRepository.save(usuarios);
    }

    // Atualiza dados do usuário
    public Usuarios atualizarUsuario(Long id, Usuarios usuariosAtualizado){
        Usuarios usuarios = buscarPorId(id);
        usuarios.setNome(usuariosAtualizado.getNome());
        usuarios.setEmail(usuariosAtualizado.getEmail());
        usuarios.setSenha(usuariosAtualizado.getSenha());
        return usuarioRepository.save(usuarios);
    }

    // Remove um usuário
    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }
}
