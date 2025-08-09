package com.igor_nascimento.sistema_produtos.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Pedidos;
import com.igor_nascimento.sistema_produtos.repository.PedidoRepository;

@Service
public class PedidoService {

    // Injeta o repositório de pedidos para acesso ao banco de dados
    @Autowired
    private PedidoRepository pedidoRepository;

    // Lista todos os pedidos
    public List<Pedidos> listar() {
        return pedidoRepository.findAll();
    }

    // Busca pedido por ID
    public Pedidos buscarPorId(Long id) {
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // Cria um novo pedido
    public Pedidos criarPedidos(Pedidos pedido) {
        pedido.setData(LocalDateTime.now()); // Define a data do pedido como agora
        return pedidoRepository.save(pedido); // Salva o pedido no banco
    }

    // Atualiza status do pedido
    public Pedidos atualizarPedidos(Long id, Pedidos atualizado) {
        Pedidos pedidos = buscarPorId(id); // Busca o pedido existente
        pedidos.setStatus(atualizado.getStatus()); // Atualiza o status
        return pedidoRepository.save(pedidos); // Salva as alterações
    }

    // Remove um pedido
    public void deletar(Long id) {
        pedidoRepository.deleteById(id); // Deleta o pedido do banco
    }
}
