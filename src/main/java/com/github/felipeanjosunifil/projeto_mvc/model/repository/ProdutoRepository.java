package com.github.felipeanjosunifil.projeto_mvc.model.repository;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    public List<Produto> findByNomeContainingAndPrecoIsLessThanEqual(String nome, Double preco);
}
