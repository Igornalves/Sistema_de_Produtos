package com.igor_nascimento.sistema_produtos.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;

import com.igor_nascimento.sistema_produtos.models.Usuarios;
import com.igor_nascimento.sistema_produtos.services.UsuarioService;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    private final UsuarioService usuarioService;

    // @Autowired
    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listarTodosUsuarios")
    public List<Usuarios> ListandoTodosUsuarios() {
        return usuarioService.listaTodos();
    }

    @GetMapping("/buscarPorCategorias/{id}")
    public Usuarios buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @PostMapping("/criandoUsuarios")
    public Usuarios criandoUsuarios(@RequestBody Usuarios usuarios){
        return usuarioService.criarUsuario(usuarios);
    }

    @PutMapping("/atualizandoUsuarios/{id}")
    public Usuarios AtualizacaoUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarios){
        return usuarioService.atualizarUsuario(id, usuarios);
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletar(id);
    }
}
