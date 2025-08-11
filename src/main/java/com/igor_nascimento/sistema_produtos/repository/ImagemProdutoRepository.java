package com.igor_nascimento.sistema_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.ImagensProduto;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagensProduto, Long> {
    // Busca imagens por produto
    List<ImagensProduto> findByProdutos_Id(Long id);
}
