package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Categorias;
import com.igor_nascimento.sistema_produtos.repository.CategoriaRepository;

@Service
public class CategoriaService {

    // Injeta o repositório de categorias para acesso ao banco de dados
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Lista todas as categorias
    public List<Categorias> listar(){
        return categoriaRepository.findAll();
    }

    // Busca categoria por ID
    public Categorias buscarPorId(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    // Cria uma nova categoria
    public Categorias criar(Categorias categorias){
        return categoriaRepository.save(categorias);
    }

    // Atualiza o nome da categoria
    public Categorias atualizarCategorias(Long id, Categorias categoriasAtualizadas){
        Categorias categorias = buscarPorId(id);
        categorias.setNome(categoriasAtualizadas.getNome());
        return categoriaRepository.save(categorias);
    }

    // Remove uma categoria
    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}
