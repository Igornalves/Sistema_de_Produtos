package com.igor_nascimento.sistema_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    
}
