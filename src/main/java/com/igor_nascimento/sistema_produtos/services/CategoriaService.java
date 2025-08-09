package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Categorias;
import com.igor_nascimento.sistema_produtos.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categorias> listar(){
        return categoriaRepository.findAll();
    }

    public Categorias buscarPorId(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categorias criar(Categorias categorias){
        return categoriaRepository.save(categorias);
    }

    public Categorias atualizarCategorias(Long id, Categorias categoriasAtualizadas){
        Categorias categorias = buscarPorId(id);
        categorias.setNome(categoriasAtualizadas.getNome());
        return categoriaRepository.save(categorias);
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}
