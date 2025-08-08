package com.igor_nascimento.sistema_produtos.models;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class EstoqueHistorico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; 
    private Integer quantidade;
    private String motivo; //entrada, saida, ajuste

    @CreationTimestamp
    private LocalDateTime data = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produtos;

    @ManyToOne
    @JoinColumn(name = "alterado_por")
    private Usuarios alteradoPor;
}
