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

import com.igor_nascimento.sistema_produtos.models.Pedidos;
import com.igor_nascimento.sistema_produtos.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {
    private final PedidoService pedidoService;

    // @Autowired
    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/listadoTodosPedido")
    public List<Pedidos> listadoTodosPedido(){
        return pedidoService.listar();
    }

    @GetMapping("/buscandoPorId/{id}")
    public Pedidos buscandoPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id);
    }

    @PostMapping("/criandoPedido")
    public Pedidos criandoPedido(@RequestBody Pedidos pedidos){
        return pedidoService.criarPedidos(pedidos);
    }

    @PutMapping("/atualizandoPedido/{id}")
    public Pedidos atualizandoPedido(@PathVariable Long id, @RequestBody Pedidos pedidos){
        return pedidoService.atualizarPedidos(id, pedidos);
    }

    @DeleteMapping("/deletarPedido")
    public void deletarPedido(@PathVariable Long id){
        pedidoService.deletar(id);
    }
}
