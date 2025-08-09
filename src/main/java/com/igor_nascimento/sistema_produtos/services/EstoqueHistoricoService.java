package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.EstoqueHistorico;
import com.igor_nascimento.sistema_produtos.models.Produtos;
import com.igor_nascimento.sistema_produtos.models.Usuarios;
import com.igor_nascimento.sistema_produtos.repository.EstoqueHistoricoRepository;
import com.igor_nascimento.sistema_produtos.repository.ProdutoRepository;
import com.igor_nascimento.sistema_produtos.repository.UsuarioRepository;

@Service
public class EstoqueHistoricoService {

    // Injeta o repositório de histórico de estoque para acesso ao banco de dados
    @Autowired
    private EstoqueHistoricoRepository estoqueHistoricoRepository;

    // Injeta o repositório de produtos para manipulação de estoque
    @Autowired
    private ProdutoRepository produtoRepository;

    // Injeta o repositório de usuários para registrar quem fez a movimentação
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todas as movimentações
    public List<EstoqueHistorico> listar(){
        return estoqueHistoricoRepository.findAll();
    }

    // Busca movimentação por ID
    public EstoqueHistorico buscarPorId(Long id){
        return estoqueHistoricoRepository.findById(id).orElseThrow(() -> new RuntimeException("Movimentação não encotrada"));
    }

    // Entrada de produtos no estoque
    public EstoqueHistorico entrada(Long produtoId, Long usuarioId, int quantidade){
        Produtos produtos = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Usuarios usuarios = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Atualiza a quantidade do produto
        produtos.setQuantidade(produtos.getQuantidade() + quantidade);
        produtoRepository.save(produtos);

        // Cria o registro de histórico de entrada
        EstoqueHistorico historico = new EstoqueHistorico();
        historico.setProdutos(produtos);
        historico.setUsuarios(usuarios);
        historico.setQuantidade(quantidade);
        historico.setTipo("entrada");
        historico.setMotivo("entrada");

        return estoqueHistoricoRepository.save(historico);
    }

    // Saída de produtos do estoque
    public EstoqueHistorico saida(Long produtosId, Long usuarioId, int quantidade){
        Produtos produtos = produtoRepository.findById(produtosId)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Usuarios usuarios = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (produtos.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        // Atualiza a quantidade do produto
        produtos.setQuantidade(produtos.getQuantidade() - quantidade);
        produtoRepository.save(produtos);

        // Cria o registro de histórico de saída
        EstoqueHistorico historico = new EstoqueHistorico();
        historico.setProdutos(produtos);
        historico.setUsuarios(usuarios);
        historico.setQuantidade(quantidade);
        historico.setTipo("saida");
        historico.setMotivo("saida");

        return estoqueHistoricoRepository.save(historico);
    }

}
