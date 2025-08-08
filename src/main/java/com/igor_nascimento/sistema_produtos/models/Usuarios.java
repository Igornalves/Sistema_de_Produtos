package com.igor_nascimento.sistema_produtos.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @CreationTimestamp
    private LocalDateTime criado_em;

    @UpdateTimestamp
    private LocalDateTime atualizado_em;

    @OneToMany(mappedBy = "usuarios")
    private List<EstoqueHistorico> historicoEstoque;

    @OneToMany(mappedBy = "usuarios")
    private List<Pedidos> pedidos;
}
