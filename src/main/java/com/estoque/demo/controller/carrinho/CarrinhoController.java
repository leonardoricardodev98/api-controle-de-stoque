package com.estoque.demo.controller.carrinho;


import com.estoque.demo.model.Carrinho;
import com.estoque.demo.model.Produto;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarrinhoController {

    private Carrinho carrinho = new Carrinho();

    private List<Produto> produtos = new ArrayList<>();


}
