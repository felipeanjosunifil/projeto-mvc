package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Produto;
import com.github.felipeanjosunifil.projeto_mvc.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImp implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Boolean novoProduto(Produto produto) throws Exception {
        try {
            repository.save(produto);
            return true;
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro ao tentar criar um produto.\n" + e.getMessage());
        }
    }

    @Override
    public List<Produto> getProdutos() {

        Iterable<Produto> produtos = repository.findAll();

        return (List<Produto>) produtos;
    }

    @Override
    public Produto getProdutoPorId(Long id) throws Exception {

        Optional<Produto> produtoEncontrado = repository.findById(id);

        if (produtoEncontrado.isPresent()) {
            return produtoEncontrado.get();
        } else {
            throw new Exception("Nenhum produto com este id foi encontrado");
        }
    }

    @Override
    public List<Produto> consultarProdutos(String nome, double valorMaximo) {
        Iterable<Produto> produtosEncontrados;
        double valorBuscar = 1000000.0;

        if (valorMaximo > 1) {
            valorBuscar = valorMaximo;
        }

        produtosEncontrados = repository.findByNomeContainingAndPrecoIsLessThanEqual(nome, valorBuscar);

        return (List<Produto>) produtosEncontrados;
    }

    @Override
    public Boolean apagarProduto(Long id) throws Exception {

        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Nenhum produto com esse id foi encontrado");
        }

        return true;
    }
}
