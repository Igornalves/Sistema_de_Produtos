package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Produtos;
import com.igor_nascimento.sistema_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

    // Injeta o repositório de produtos para acesso ao banco de dados
    @Autowired
    private ProdutoRepository produtoRepository;

    // Lista todos os produtos
    public List<Produtos> listar(){
        return produtoRepository.findAll();
    }

    // Busca produto por ID
    public Produtos buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Cria um novo produto
    public Produtos criarProdutos(Produtos produtos){
        return produtoRepository.save(produtos);
    }

    // Atualiza dados do produto
    public Produtos atulizarProdutos(Long id, Produtos produtosAtualizados){
        Produtos produtos = buscarPorId(id);
        produtos.setNome(produtosAtualizados.getNome());
        produtos.setDescricao(produtosAtualizados.getDescricao());
        produtos.setPreco(produtosAtualizados.getPreco());
        produtos.setQuantidade(produtosAtualizados.getQuantidade());
        return produtoRepository.save(produtos);
    }

    // Remove um produto
    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }

}
