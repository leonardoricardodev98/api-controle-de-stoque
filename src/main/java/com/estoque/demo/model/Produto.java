package com.estoque.demo.model;

public class Produto {

    private Long id;

    private String nome;
    private String categoria;

    private int quantidade;
    private int quantidadeMinima;

    public Produto(Long id, String nome, String categoria, int quantidade, int quantidadeMinima) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }
}
