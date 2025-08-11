package com.igor_nascimento.sistema_produtos.routes;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor_nascimento.sistema_produtos.models.EstoqueHistorico;
import com.igor_nascimento.sistema_produtos.services.EstoqueHistoricoService;

@RestController
@RequestMapping("/api/estoque")

public class EstoqueHistoricoController {
    private final EstoqueHistoricoService estoqueHistoricoService;

    public EstoqueHistoricoController(EstoqueHistoricoService estoqueHistoricoService) {
        this.estoqueHistoricoService = estoqueHistoricoService;
    }

    @GetMapping("/listarMovimentacoes")
    public List<EstoqueHistorico> listarMovimentacoes(){
        return estoqueHistoricoService.listar();
    }
    
    @GetMapping("/buscarPorId/{id}")
    public EstoqueHistorico buscarPorId(@PathVariable Long id){
        return estoqueHistoricoService.buscarPorId(id);
    }


    @PostMapping("/entrada")
    public EstoqueHistorico entrada(@RequestBody EstoqueHistorico estoqueHistorico){
        if (estoqueHistorico.getProdutos() == null || estoqueHistorico.getProdutos().getId() == null) {
            throw new IllegalArgumentException("O campo 'produtos.id' é obrigatório para registrar a entrada no estoque.");
        }
        if (estoqueHistorico.getUsuarios() == null || estoqueHistorico.getUsuarios().getId() == null) {
            throw new IllegalArgumentException("O campo 'usuarios.id' é obrigatório para registrar a entrada no estoque.");
        }
        if (estoqueHistorico.getQuantidade() == null || estoqueHistorico.getQuantidade() <= 0) {
            throw new IllegalArgumentException("O campo 'quantidade' deve ser informado e maior que zero.");
        }

        Long produtoId = estoqueHistorico.getProdutos().getId();
        Long usuarioId = estoqueHistorico.getUsuarios().getId();
        int quantidade = estoqueHistorico.getQuantidade();

        return estoqueHistoricoService.entrada(produtoId, usuarioId, quantidade);
    }

    @PostMapping("/saida")
    public EstoqueHistorico saida(@RequestBody EstoqueHistorico estoqueHistorico){
        // Validação detalhada dos parâmetros recebidos
        if (estoqueHistorico.getProdutos() == null || estoqueHistorico.getProdutos().getId() == null) {
            throw new IllegalArgumentException("O campo 'produtos.id' é obrigatório para registrar a saída do estoque.");
        }
        if (estoqueHistorico.getUsuarios() == null || estoqueHistorico.getUsuarios().getId() == null) {
            throw new IllegalArgumentException("O campo 'usuarios.id' é obrigatório para registrar a saída do estoque.");
        }
        if (estoqueHistorico.getQuantidade() == null || estoqueHistorico.getQuantidade() <= 0) {
            throw new IllegalArgumentException("O campo 'quantidade' deve ser informado e maior que zero.");
        }

        Long produtoId = estoqueHistorico.getProdutos().getId();
        Long usuarioId = estoqueHistorico.getUsuarios().getId();
        int quantidade = estoqueHistorico.getQuantidade();

        return estoqueHistoricoService.saida(produtoId, usuarioId, quantidade);
    }

}
