package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Usuarios;
import com.igor_nascimento.sistema_produtos.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> listaTodos() {
        return usuarioRepository.findAll();
    }

    public Usuarios buscarPorId(long id){
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public Usuarios criarUsuario(Usuarios usuarios){
        return usuarioRepository.save(usuarios);
    }

    public Usuarios atualizarUsuario(Long id, Usuarios usuariosAtualizado){
        Usuarios usuarios = buscarPorId(id);
        usuarios.setNome(usuariosAtualizado.getNome());
        usuarios.setEmail(usuariosAtualizado.getEmail());
        usuarios.setSenha(usuariosAtualizado.getSenha());
        return usuarioRepository.save(usuarios);
    }

    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }
}
