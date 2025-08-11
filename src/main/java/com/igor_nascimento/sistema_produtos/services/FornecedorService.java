package com.igor_nascimento.sistema_produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_nascimento.sistema_produtos.models.Fornecedores;
import com.igor_nascimento.sistema_produtos.repository.FornecedorRepository;

@Service
public class FornecedorService {

    // Injeta o repositório de fornecedores para acesso ao banco de dados
    @Autowired
    private FornecedorRepository fornecedorRepository;

    // Lista todos os fornecedores
    public List<Fornecedores> listar(){
        return fornecedorRepository.findAll();
    }

    // Busca fornecedor por ID
    public Fornecedores buscarPorId(Long id){
        return fornecedorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    // Cria um novo fornecedor
    public Fornecedores criarFornecedor(Fornecedores fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Atualiza dados do fornecedor
    public Fornecedores atualizaFornecedor(Long id, Fornecedores fornecedoresAtualizados){
        Fornecedores fornecedores = buscarPorId(id);
        fornecedores.setNome(fornecedoresAtualizados.getNome());
        fornecedores.setContato(fornecedoresAtualizados.getContato());
        fornecedores.setCnpj(fornecedoresAtualizados.getCnpj());
        fornecedores.setContato(fornecedoresAtualizados.getContato());
        fornecedores.setEmail(fornecedoresAtualizados.getEmail());
        return fornecedorRepository.save(fornecedores);
    }

    // Remove um fornecedor
    public void deletar(Long id){
        fornecedorRepository.deleteById(id);
    }

}
