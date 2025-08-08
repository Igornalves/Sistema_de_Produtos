package com.igor_nascimento.sistema_produtos.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;

    @CreationTimestamp
    private LocalDateTime criado_em;

    @UpdateTimestamp
    private LocalDateTime atualizado_em;

    @ManyToOne
    private Categorias categorias;

    @ManyToOne
    private Fornecedores fornecedores;

    @OneToMany(mappedBy = "produtos")
    private List<ImagensProduto> imagens;

    @OneToMany(mappedBy = "produtos")
    private List<EstoqueHistorico> historicoEstoque;

    @OneToMany(mappedBy = "produtos")
    private List<ItensPedido> itensPedidos;

}
