package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.Produto;

import java.util.List;

public class ProdutoServiceImp implements ProdutoService {

    @Override
    public Boolean novoProduto(Produto produto) {
        return null;
    }

    @Override
    public List<Produto> getProdutos() {
        return List.of();
    }

    @Override
    public Produto getProdutoPorId(int id) {
        return null;
    }

    @Override
    public List<Produto> consultarProdutos(String nome, double valorMaximo) {
        return List.of();
    }

    @Override
    public Boolean apagarProduto(int id) {
        return null;
    }
}
