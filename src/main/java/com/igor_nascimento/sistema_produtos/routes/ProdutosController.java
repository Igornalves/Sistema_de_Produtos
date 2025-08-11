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

import com.igor_nascimento.sistema_produtos.models.Produtos;
import com.igor_nascimento.sistema_produtos.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    private final ProdutoService produtoService;

    // @Autowired
    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listaTodosProdutos")
    public List<Produtos> listaTodosProdutos(){
        return produtoService.listar();
    }

    @GetMapping("/buscarPorProdutos/{id}")
    public Produtos buscarPorProdutos(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping("/criandoProdutos")
    public Produtos criadoProduto(@RequestBody Produtos produtos){
        return produtoService.criarProdutos(produtos);
    }

    @PutMapping("/atualizandoProdutos/{id}")
    public Produtos atualizandoProdutos(@PathVariable Long id, @RequestBody Produtos produtos){
        return produtoService.atulizarProdutos(id, produtos);
    }

    @DeleteMapping("/deletarProdutos/{id}")
    public void deletarProdutos(@PathVariable Long id){
        produtoService.deletar(id);
    }
}
