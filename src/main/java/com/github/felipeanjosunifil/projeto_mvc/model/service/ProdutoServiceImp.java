package com.github.felipeanjosunifil.projeto_mvc.model.service;

import com.github.felipeanjosunifil.projeto_mvc.model.ProdutoRepository;
import com.github.felipeanjosunifil.projeto_mvc.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return (List<Produto>) repository.findAll();
    }

    @Override
    public Produto getProdutoPorId(int id) throws Exception {
        Produto produto = null;

//        for (Produto p : produtos) {
//            if (p.getId() == id) {
//                produto = p;
//            }
//        }

        if(produto != null){
            return produto;
        } else {
            throw new Exception("Nenhum produto com este id foi encontrado");
        }
    }

    @Override
    public List<Produto> consultarProdutos(String nome, double valorMaximo) {
        List<Produto> produtosEncontrados = new ArrayList<>();
        double valorBuscar = 1000000.0;

        if (valorMaximo > 1) {
            valorBuscar = valorMaximo;
        }

//        for (Produto p: produtos) {
//            if (p.getNome().toLowerCase().contains(nome.toLowerCase()) && p.getPreco() <= valorBuscar) {
//                produtosEncontrados.add(p);
//            }
//        }

        return produtosEncontrados;
    }

    @Override
    public Boolean apagarProduto(int id) throws Exception {
//        int deletar = 0;
//        int index = -1;

//        for (Produto p : produtos) {
//            index++;
//            if (p.getId() == id) {
//                deletar = index;
//            }
//        }

//        produtos.remove(deletar);

//        boolean deletou = produtos.removeIf(p -> p.getId() == id);//forma reduzida para remover item

//        if (!deletou) {
//            throw new Exception("Nenhum produto com esse id foi encontrado");
//        }

        return true;
    }
}
