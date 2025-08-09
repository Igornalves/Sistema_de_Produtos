package com.igor_nascimento.sistema_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_nascimento.sistema_produtos.models.ItensPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItensPedido, Long>{
    List<ItensPedido> findByPedidos(Long pedidos);
}
