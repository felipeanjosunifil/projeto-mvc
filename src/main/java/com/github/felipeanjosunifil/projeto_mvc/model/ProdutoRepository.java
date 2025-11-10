package com.github.felipeanjosunifil.projeto_mvc.model;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
