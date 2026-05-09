package com.estoque.demo.controller;

import com.estoque.demo.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @PostMapping("/produtos")
    public void adicionarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
    }

    @PutMapping("/produtos/{id}")
    public void atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {

        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                produtos.remove(produto);
                produtos.add(produtoAtualizado);
                break;
            }
        }
    }

    @DeleteMapping("/produtos/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }
}
