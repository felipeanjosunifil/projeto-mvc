package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Produto;
import java.util.List;

public interface ProdutoService {
    Boolean novoProduto(Produto produto) throws Exception;
    List<Produto> getProdutos();
    Produto getProdutoPorId(Long id) throws Exception;
    List<Produto> consultarProdutos(String nome, double valorMaximo);
    Boolean apagarProduto(Long id) throws Exception;
}
