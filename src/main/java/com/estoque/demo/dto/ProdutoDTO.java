package com.estoque.demo.dto;

public class ProdutoDTO {

    private String nome;

    private int quantidade;

    private String categoria;

    public ProdutoDTO(String nome, int quantidade, String categoria) {

        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }
}
