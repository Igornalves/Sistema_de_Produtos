package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.ImagensProduto;
import com.igor_nascimento.sistema_produtos.models.Produtos;
import com.igor_nascimento.sistema_produtos.repository.ImagemProdutoRepository;
import com.igor_nascimento.sistema_produtos.repository.ProdutoRepository;

@Service
public class ImagemProdutoService {

    // Injeta o repositório de imagens de produtos para acesso ao banco de dados
    @Autowired
    private ImagemProdutoRepository imagemProdutoRepository;

    // Injeta o repositório de produtos para associar imagens a produtos
    @Autowired
    private ProdutoRepository produtoRepository;

    // Lista imagens de um produto
    public List<ImagensProduto> listarPorProduto(Long produtos){
        return imagemProdutoRepository.findByProdutos_Id(produtos);
    }

    // Adiciona imagem a um produto
    public ImagensProduto adicionarImagem(Long produtoId, ImagensProduto imagem){
        Produtos produtos = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        imagem.setProdutos(produtos);
        return imagemProdutoRepository.save(imagem);
    }

    // Remove imagem de um produto
    public void deletarImagem(Long produtosId, Long imagemId){
        ImagensProduto imagem = imagemProdutoRepository.findById(imagemId)
            .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));
        if (imagem.getProdutos() == null || !imagem.getProdutos().getId().equals(produtosId)) {
            throw new RuntimeException("Imagem não pertence ao produto informado");
        }
        imagemProdutoRepository.delete(imagem);
    }
}
