package com.estoque.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Produto {

    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "A categoria não pode estar vazia.")
    private String categoria;

    @Min(value = 0, message = "A quantidade não pode ser negativa.")
    private int quantidade;

    @Min(value = 0, message = "A quantidade mínima não pode ser negativa.")
    private int quantidadeMinima;

    public Produto(Long id, String nome, String categoria, int quantidade, int quantidadeMinima) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
