package com.estoque.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> itens = new ArrayList<>();

    public List<Produto> getItens() {
        return itens;
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }
}
