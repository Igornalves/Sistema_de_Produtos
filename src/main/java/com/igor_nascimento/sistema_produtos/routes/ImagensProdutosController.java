package com.igor_nascimento.sistema_produtos.routes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;

import com.igor_nascimento.sistema_produtos.models.ImagensProduto;
import com.igor_nascimento.sistema_produtos.services.ImagemProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ImagensProdutosController {
    private final ImagemProdutoService imagemProdutoService;

    // @Autowired
    public ImagensProdutosController(ImagemProdutoService imagemProdutoService) {
        this.imagemProdutoService = imagemProdutoService;
    }

    @GetMapping("/{id}/imagens/listaTodasImagensPorProduto")
    public List<ImagensProduto> listarImagemPorProdutos(@PathVariable Long id){
        return imagemProdutoService.listarPorProduto(id);
    }

    @PostMapping("/{id}/imagens/adicionarImagemProdutos")
    public ImagensProduto adicionarImagemProdutos(@PathVariable Long id, @RequestBody ImagensProduto imagensProduto){
        return imagemProdutoService.adicionarImagem(id, imagensProduto);
    }

    @DeleteMapping("/{id}/imagens/removerImagens/{idImg}")
    public void removerImagens(@PathVariable("id") Long id, @PathVariable("idImg") Long idImg){
        imagemProdutoService.deletarImagem(id, idImg);
    }
}
