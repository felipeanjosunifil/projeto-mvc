package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.Produto;
import java.util.List;

public interface ProdutoService {
    public Boolean novoProduto(Produto produto);
    public List<Produto> getProdutos();
    public Produto getProdutoPorId(int id);
    public List<Produto> consultarProdutos(String nome, double valorMaximo);
    public Boolean apagarProduto(int id);
}
