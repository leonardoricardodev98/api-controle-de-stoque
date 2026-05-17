package com.estoque.demo.service;

import com.estoque.demo.model.Produto;
import org.springframework.stereotype.Service;
import com.estoque.demo.exception.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> ListarProdutos() {
        return produtos;
    }

    public String adicionarProduto(Produto produto) {

        for (Produto p : produtos) {

            if (p.getId().equals(produto.getId())) {
                return "Já existe um produto com esse ID.";
            }
        }

        produtos.add(produto);

        return "Produto adicionado com sucesso.";
    }

    public Produto buscarProdutoPorId(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }

        throw new ProdutoNaoEncontradoException();
    }

    public String atualizarProduto(Long id, Produto produtoAtualizado) {

        for (Produto produto : produtos) {

            if (produto.getId().equals(id)) {

                produtos.remove(produto);

                produtos.add(produtoAtualizado);

                return "Produto atualizado com sucesso.";
            }
        }

        return "Produto não encontrado.";
    }

    public String deletarProduto(Long id) {

        for (Produto produto : produtos) {

            if (produto.getId().equals(id)) {

                produtos.remove(produto);

                return "Produto deletado com sucesso.";
            }
        }

        return "Produto não encontrado.";
    }
}
