package com.github.felipeanjosunifil.projeto_mvc.model.repository;

import com.github.felipeanjosunifil.projeto_mvc.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
