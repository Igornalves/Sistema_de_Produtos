package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.ItensPedido;
import com.igor_nascimento.sistema_produtos.models.Pedidos;
import com.igor_nascimento.sistema_produtos.models.Produtos;
import com.igor_nascimento.sistema_produtos.repository.ItensPedidoRepository;
import com.igor_nascimento.sistema_produtos.repository.PedidoRepository;
import com.igor_nascimento.sistema_produtos.repository.ProdutoRepository;

@Service
public class ItemPedidoService {

    // Injeta o repositório de itens do pedido para acesso ao banco de dados
    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    // Injeta o repositório de pedidos para associar itens ao pedido
    @Autowired
    private PedidoRepository pedidoRepository;

    // Injeta o repositório de produtos para associar itens ao produto
    @Autowired
    private ProdutoRepository produtoRepository;

    // Lista itens de um pedido
    public List<ItensPedido> listarPorPedido(Long pedidoId) {
        return itensPedidoRepository.findByPedidosId(pedidoId);
    }

    // Adiciona item a um pedido
    public ItensPedido adicionar(Long pedidoId, ItensPedido item) {
        Pedidos pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        Produtos produto = produtoRepository.findById(item.getProdutos().getId())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        item.setPedidos(pedido);
        item.setProdutos(produto);
        return itensPedidoRepository.save(item);
    }

    // Atualiza quantidade do item
    public ItensPedido atualizarQuantidade(Long pedidoId, Long itemId, int novaQuantidade) {
        ItensPedido item = itensPedidoRepository.findByIdAndPedidosId(itemId, pedidoId)
            .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        item.setQuantidade(novaQuantidade);
        return itensPedidoRepository.save(item);
    }

    // Remove item de um pedido
    public void remover(Long pedidoId, Long itemId) {
        ItensPedido item = itensPedidoRepository.findByIdAndPedidosId(itemId, pedidoId)
            .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        itensPedidoRepository.delete(item);
    }
}
