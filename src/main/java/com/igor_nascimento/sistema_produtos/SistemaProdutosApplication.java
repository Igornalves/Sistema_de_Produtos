package com.igor_nascimento.sistema_produtos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sistema de Produtos", version = "1.0", description = "É uma aplicação desenvolvida para gerenciar o cadastro, consulta, atualização e exclusão de produtos em uma empresa. Ele permite o controle eficiente do estoque, facilitando o registro de informações detalhadas sobre cada produto, como nome, categoria, preço, quantidade disponível e fornecedor. O sistema oferece uma interface intuitiva para os usuários, possibilitando a busca rápida de produtos, geração de relatórios e integração com outros módulos empresariais. Seu objetivo é otimizar a gestão de produtos, reduzir erros operacionais e fornecer dados precisos para a tomada de decisões estratégicas."))
public class SistemaProdutosApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemaProdutosApplication.class, args);
	}
}
