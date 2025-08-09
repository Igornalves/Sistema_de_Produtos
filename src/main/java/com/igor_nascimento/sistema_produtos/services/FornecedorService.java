package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Fornecedores;
import com.igor_nascimento.sistema_produtos.repository.FornecedorRepository;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedores> listar(){
        return fornecedorRepository.findAll();
    }

    public Fornecedores buscarPorId(Long id){
        return fornecedorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedores criarFornecedor(Long id, Fornecedores fornecedoresAtualizados){
        Fornecedores fornecedores = buscarPorId(id);
        fornecedores.setNome(fornecedoresAtualizados.getNome());
        fornecedores.setContato(fornecedoresAtualizados.getContato());
        fornecedores.setCnpj(fornecedoresAtualizados.getCnpj());
        fornecedores.setContato(fornecedoresAtualizados.getContato());
        fornecedores.setEmail(fornecedoresAtualizados.getEmail());
        return fornecedorRepository.save(fornecedores);
    }

    public void deletar(Long id){
        fornecedorRepository.deleteById(id);
    }

}
