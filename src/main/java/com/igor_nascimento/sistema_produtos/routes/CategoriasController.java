package com.igor_nascimento.sistema_produtos.routes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;

import com.igor_nascimento.sistema_produtos.models.Categorias;
import com.igor_nascimento.sistema_produtos.services.CategoriaService;


@RestController
@RequestMapping ("/api/categorias")
public class CategoriasController {
    private final CategoriaService categoriaService;

    // @Autowired
    public CategoriasController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listarTodasCategorias")
    public List<Categorias> listarTodos(){
        return categoriaService.listar();
    }

    @GetMapping("/buscandoPorCategorias/{id}")
    public Categorias buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping("/criandoCategorias")
    public Categorias criandoCategorias(@RequestBody Categorias categorias){
        return categoriaService.criar(categorias);
    }

    @PutMapping("/atualizandoCategorias/{id}")
    public Categorias atualizandoCategorias(@PathVariable Long id, @RequestBody Categorias categorias){
        return categoriaService.atualizarCategorias(id, categorias);
    }

    @DeleteMapping("/deletarCategorias/{id}")
    public void deletarCategorias(@PathVariable Long id){
        categoriaService.deletar(id);
    }
}
