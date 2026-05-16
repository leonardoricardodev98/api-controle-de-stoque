package com.estoque.demo.controller;

import com.estoque.demo.model.Carrinho;
import com.estoque.demo.model.Produto;
import org.springframework.web.bind.annotation.*;
import com.estoque.demo.service.ProdutoService;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    private Carrinho carrinho = new Carrinho();

    @PostMapping("/carrinho/{id}")
    public String adicionarAoCarrinho(@PathVariable Long id) {

        for (Produto p : produtos) {

            if (p.getId().equals(id)) {

                if (p.getQuantidade() <= 0) {
                    return "Produto sem estoque.";
                }

                carrinho.adicionarProduto(p);

                p.setQuantidade(p.getQuantidade() - 1);

                return "Produto adicionado ao carrinho.";
            }
        }

        return "Produto não encontrado.";
    }

    @DeleteMapping("/carrinho/{id}")
    public String removerDoCarrinho(@PathVariable Long id) {
        for (Produto produto : carrinho.getItens()) {
            if (produto.getId().equals(id)) {
                carrinho.removerProduto(produto);

                produto.setQuantidade(produto.getQuantidade() + 1);

                return "Produto removido do carrinho.";
            }
        }

        return "Produto não encontrado no carrinho.";
    }

    @GetMapping("/carrinho")
    public List<Produto> visualizarCarrinho() {
        return carrinho.getItens();
    }

    @PostMapping("/produtos")
    public ResponseEntity<String> adicionarProduto(@RequestBody Produto produto) {
        String resposta = produtoService.adicionarProduto(produto);

        if (resposta.equals("Já existe um produto com esse ID.")) {
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.status(201).body(resposta);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Long id) {

        Produto produto = produtoService.buscarProdutoPorId(id);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    @PutMapping("/produtos/{id}")
    public String atualizarProduto(@PathVariable Long id,
                                   @RequestBody Produto produtoAtualizado) {

        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

    @DeleteMapping("/produtos/{id}")
    public String deletarProduto(@PathVariable Long id) {

        return produtoService.deletarProduto(id);
    }

    @GetMapping("/compras/sugeridas")
    public List<Produto> listarcomprasSugeridas() {

        List<Produto> sugestoes = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getQuantidade() <= produto.getQuantidadeMinima()) {
                sugestoes.add(produto);
            }
        }

        return sugestoes;
    }

    @GetMapping("/produtos/categoria/{categoria}")
    public List<Produto> buscarPorCategoria(@PathVariable String categoria) {
        List<Produto> produtosFiltrados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                produtosFiltrados.add(produto);
            }
        }

        return produtosFiltrados;
    }
}
