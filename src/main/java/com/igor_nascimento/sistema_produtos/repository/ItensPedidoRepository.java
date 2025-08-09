package com.igor_nascimento.sistema_produtos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.ItensPedido;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
    // Busca itens por pedido
    List<ItensPedido> findByPedidosId(Long pedidosId);
    // Busca item por id e pedido
    Optional<ItensPedido> findByIdAndPedidosId(Long id, Long pedidosId);
}
