package com.igor_nascimento.sistema_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.Pedidos;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long> {
    // Busca pedidos por usuário
    List<Pedidos> findByUsuarios_Id(Long id);
}
