package com.igor_nascimento.sistema_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.EstoqueHistorico;

@Repository
public interface EstoqueHistoricoRepository extends JpaRepository<EstoqueHistorico,Long> {

    // Busca histórico de um produto
    List<EstoqueHistorico> findByProdutos(Long produtos);

    // Busca histórico de um usuário
    List<EstoqueHistorico> findByUsuarios(Long usuarios);
}
