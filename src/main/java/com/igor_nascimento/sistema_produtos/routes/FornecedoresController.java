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

import com.igor_nascimento.sistema_produtos.models.Fornecedores;
import com.igor_nascimento.sistema_produtos.services.FornecedorService;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedoresController {
    private final FornecedorService fornecedorService;

    // @Autowired
    public FornecedoresController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/listaTodosFornecedores")
    public List<Fornecedores> listarTodos(){
        return fornecedorService.listar();
    }

    @GetMapping("/buscandoFornercedores/{id}")
    public Fornecedores buscarPorId(@PathVariable Long id){
        return fornecedorService.buscarPorId(id);
    }

    @PostMapping("/criandoFornercedor")
    public Fornecedores criandoFornercedor(@RequestBody Fornecedores fornecedores){
        return fornecedorService.criarFornecedor(fornecedores);
    }

    @PutMapping("/atualizandoFornercedor/{id}")
    public Fornecedores atualizandoFornercedores(@PathVariable Long id, @RequestBody Fornecedores fornecedores){
        return fornecedorService.atualizaFornecedor(id,fornecedores);
    }

    @DeleteMapping("/deletarFornecerdor/{id}")
    public void deletarFornecerdor(@PathVariable Long id){
        fornecedorService.deletar(id);
    }
}
