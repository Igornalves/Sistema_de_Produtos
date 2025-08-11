package com.igor_nascimento.sistema_produtos.routes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;

import com.igor_nascimento.sistema_produtos.models.ItensPedido;
import com.igor_nascimento.sistema_produtos.services.ItemPedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class ItensPedidoController {
    private final ItemPedidoService itemPedidoService;

    // @Autowired
    public ItensPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping("/{id}/itens/listarItens")
    public List<ItensPedido> listarItensPedido(@PathVariable Long id){
        return itemPedidoService.listarPorPedido(id);
    }

    @PostMapping("/{id}/itens/adicionarItens")
    public ItensPedido adicionarItens(@PathVariable Long id, @RequestBody ItensPedido itensPedido){
        return itemPedidoService.adicionar(id, itensPedido);
    }

    @PutMapping("/{id}/itens/atualizarItensPedido/{idItens}")
    public ItensPedido atualizarItensPedido(
            @PathVariable("id") Long pedidoId,
            @PathVariable("idItens") Long idItens,
            @RequestBody ItensPedido itensPedido) {
        if (itensPedido.getQuantidade() == null || itensPedido.getQuantidade() <= 0) {
            throw new IllegalArgumentException("O campo 'quantidade' deve ser informado e maior que zero.");
        }
        return itemPedidoService.atualizarQuantidade(pedidoId, idItens, itensPedido.getQuantidade());
    }

    @DeleteMapping("/removerItens/{idItem}")
    public void removerItens(@PathVariable("id") Long id, @PathVariable("idItem") Long idItem){
        itemPedidoService.remover(id, idItem);
    }
}
