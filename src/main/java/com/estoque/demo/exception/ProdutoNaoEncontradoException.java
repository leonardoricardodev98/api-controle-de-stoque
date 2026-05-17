package com.estoque.demo.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado.");
    }

}
